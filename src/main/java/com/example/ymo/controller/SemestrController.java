package com.example.ymo.controller;

import com.example.ymo.entity.Semestr;
import com.example.ymo.service.SemestrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/semestr")
public class SemestrController {
    @Autowired
    SemestrService semestrService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(semestrService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Integer id ) {
        try {
            return ResponseEntity.ok(semestrService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Semestr semestr, @RequestParam Integer nodeId) {
        try {
            return ResponseEntity.ok(semestrService.add(semestr, nodeId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(semestrService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
