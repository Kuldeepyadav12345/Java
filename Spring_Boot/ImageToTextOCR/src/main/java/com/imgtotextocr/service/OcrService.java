package com.imgtotextocr.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import com.imgtotextocr.util.OcrUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OcrService {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String CUSTOM_NEWLINE = "NEWLINE";

    // tesseractPath should point to tessdata folder, not the executable
    @Value("${tesseract.path}")
    private String tesseractPath;

    public String extractText(MultipartFile image) {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath(tesseractPath); // Should be tessdata folder path

        // Check if path ends with "tesseract.exe" and warn
        if (tesseractPath.toLowerCase().endsWith("tesseract.exe")) {
            return "Error: tesseract.path should point to the tessdata directory, not the executable. Example: C:/Program Files/Tesseract-OCR/tessdata";
        }

        File tempFile = null;
        try {
            tempFile = File.createTempFile("ocr_", image.getOriginalFilename());
            image.transferTo(tempFile);
            String result = tesseract.doOCR(tempFile);

            // Post-process the result to ensure proper formatting and structure
            String formattedResult = formatOcrOutput(result);
            return formattedResult;
        } catch (IOException | TesseractException e) {
            return "Error: " + e.getMessage();
        } finally {
            if (tempFile != null && tempFile.exists()) {
                tempFile.delete();
            }
        }
    }

    // Helper method to format OCR output as per required configuration sections
    private String formatOcrOutput(String ocrText) {
        try {
            // Parse JSON response if present
            if (ocrText.trim().startsWith("{")) {
                JsonNode jsonNode = objectMapper.readTree(ocrText);
                ocrText = jsonNode.get("text").asText();
            }

            // First, normalize all line endings
            ocrText = ocrText.replace("\\r\\n", "/n")
                            .replace("\\n", "/n")
                            .replace("\r", "/n");

            // Split into lines and process
            String[] lines = ocrText.split("/n");
            StringBuilder formatted = new StringBuilder();
            boolean isFirstLine = true;

            for (String line : lines) {
                line = cleanupLine(line);
                
                if (!isFirstLine) {
                    // Add custom newline marker
                    if (line.startsWith("#")) {
                        if (!formatted.toString().endsWith(CUSTOM_NEWLINE)) {
                            formatted.append(CUSTOM_NEWLINE);
                        }
                        formatted.append(CUSTOM_NEWLINE);
                    } else if (!line.isEmpty()) {
                        formatted.append(CUSTOM_NEWLINE);
                    }
                }

                if (!line.isEmpty()) {
                    if (line.startsWith("#")) {
                        formatted.append(line);
                    } else {
                        formatted.append("    ").append(line);
                    }
                }
                
                isFirstLine = false;
            }

            return formatted.toString().trim();
        } catch (Exception e) {
            return ocrText;
        }
    }

    private String cleanupLine(String line) {
        // Remove extra spaces while preserving indentation
        line = line.trim();
        
        // Clean up property lines
        if (!line.isEmpty() && !line.startsWith("#")) {
            // Normalize spaces around equals sign
            line = line.replaceAll("\\s*=\\s*", "=");
            // Clean up multiple spaces
            //line = line.replaceAll("\\s+", " ");
        }
        
        return line;
    }
}
