package com.example.ymo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/semestr")
public class SemestrController {
    @GetMapping("/")
    public ResponseEntity getSemestr() {
        try {
            return ResponseEntity.ok("Работает");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Ошибка");
        }
    }
}
