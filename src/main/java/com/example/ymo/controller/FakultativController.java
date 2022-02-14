package com.example.ymo.controller;

import com.example.ymo.entity.Fakultativ;
import com.example.ymo.service.FakultativService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fakultativ")
public class FakultativController {
    @Autowired
    FakultativService fakultativService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(fakultativService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(fakultativService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Fakultativ fakultativ, @RequestParam Integer planId) {
        try {
            return ResponseEntity.ok(fakultativService.add(fakultativ, planId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(fakultativService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
