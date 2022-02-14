package com.example.ymo.controller;

import com.example.ymo.entity.WeeksSemestr;
import com.example.ymo.service.WeeksSemestrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weeks_semestr")
public class WeeksSemestrController {
    @Autowired
    WeeksSemestrService weeksSemestrService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(weeksSemestrService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(weeksSemestrService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody WeeksSemestr weeksSemestr, @RequestParam Integer planId) {
        try {
            return ResponseEntity.ok(weeksSemestrService.add(weeksSemestr, planId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(weeksSemestrService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
