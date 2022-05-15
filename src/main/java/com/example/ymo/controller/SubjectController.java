package com.example.ymo.controller;

import com.example.ymo.entity.Competence;
import com.example.ymo.entity.Node;
import com.example.ymo.entity.Subject;
import com.example.ymo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(subjectService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(subjectService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Subject node, @RequestParam Integer unitId) {
        try {
            return ResponseEntity.ok(subjectService.add( node,unitId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(subjectService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
