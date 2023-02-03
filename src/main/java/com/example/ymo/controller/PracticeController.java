package com.example.ymo.controller;

import com.example.ymo.entity.Practice;
import com.example.ymo.service.PracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/practice")
public class PracticeController {
    @Autowired
    PracticeService practiceService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(practiceService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(practiceService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Practice practice, @RequestParam Integer planId) {
        try {
            return ResponseEntity.ok(practiceService.add(practice, planId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    @GetMapping(value = "/planId/{planId}")
    public ResponseEntity getForOnePlan(@PathVariable Integer planId) {
        try {
            return ResponseEntity.ok(practiceService.getForOnePlan(planId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(practiceService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
