package com.imgtotextocr.controller;

import com.imgtotextocr.service.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/ocr")
public class OcrController {

    @Autowired
    private OcrService ocrService;

    @PostMapping
    public ResponseEntity<Map<String, String>> extractText(@RequestParam("image") MultipartFile image) {
        String text = ocrService.extractText(image);
        Map<String, String> response = new HashMap<>();
        response.put("text", text);
        return ResponseEntity.ok(response);
    }
}
