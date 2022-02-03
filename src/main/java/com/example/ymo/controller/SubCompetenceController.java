package com.example.ymo.controller;

import com.example.ymo.entity.SubCompetence;
import com.example.ymo.service.SubCompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sub_competence")
public class SubCompetenceController {
    @Autowired
    SubCompetenceService subCompetenceService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(subCompetenceService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Integer id ) {
        try {
            return ResponseEntity.ok(subCompetenceService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody SubCompetence subCompetence, @RequestParam Integer competenceId, @RequestParam Integer subjectId) {
        try {
            return ResponseEntity.ok(subCompetenceService.add(subCompetence, competenceId,subjectId ));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(subCompetenceService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
