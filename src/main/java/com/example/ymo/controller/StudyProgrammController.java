package com.example.ymo.controller;

import com.example.ymo.entity.StudyProgramm;
import com.example.ymo.service.StudyProgrammService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/study_programm")
public class StudyProgrammController {
    @Autowired
    StudyProgrammService studyProgrammService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(studyProgrammService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Integer id ) {
        try {
            return ResponseEntity.ok(studyProgrammService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody StudyProgramm studyProgramm, @RequestParam Integer subjectId) {
        try {
            return ResponseEntity.ok(studyProgrammService.add(studyProgramm, subjectId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(studyProgrammService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
