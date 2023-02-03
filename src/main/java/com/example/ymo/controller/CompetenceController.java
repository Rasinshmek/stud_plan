package com.example.ymo.controller;

import com.example.ymo.entity.Competence;
import com.example.ymo.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/competence")
public class CompetenceController {
    @Autowired
    CompetenceService competenceService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(competenceService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(competenceService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/planId/{planId}")
    public ResponseEntity getForOnePlan(@PathVariable Integer planId) {
        try {
            return ResponseEntity.ok(competenceService.getForOnePlan(planId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Competence competence) {
        try {
            return ResponseEntity.ok(competenceService.add(competence));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(competenceService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
