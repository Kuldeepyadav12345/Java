package com.imgtotextocr.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.regex.Pattern;

public class OcrUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Pattern JSON_PATTERN = Pattern.compile("\\{\"text\":\"(.*?)\"\\}");

    public static String formatOcrText(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }

        try {
            // Check if the input is JSON format
            if (input.trim().startsWith("{") && input.contains("\"text\":")) {
                // Extract text from JSON
                var matcher = JSON_PATTERN.matcher(input);
                if (matcher.find()) {
                    input = matcher.group(1);
                }
            }

            // Replace escaped newlines with /n
            String text = input.replace("\\n", "/n");
            
            // Format sections and indentation
            StringBuilder formatted = new StringBuilder();
            String[] lines = text.split("/n");
            boolean isFirstLine = true;

            for (String line : lines) {
                if (!isFirstLine) {
                    formatted.append("/n");
                }
                
                // Handle section headers
                if (line.startsWith("#")) {
                    if (!isFirstLine) {
                        formatted.append("/n");
                    }
                    formatted.append(line);
                } else if (!line.trim().isEmpty()) {
                    // Preserve indentation for non-empty lines
                    if (line.startsWith("    ")) {
                        formatted.append(line);
                    } else {
                        formatted.append("    ").append(line.trim());
                    }
                }
                
                isFirstLine = false;
            }

            return formatted.toString();
        } catch (Exception e) {
            return input; // Return original text if processing fails
        }
    }
}