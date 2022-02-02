package com.example.ymo.controller;

import com.example.ymo.entity.CreatorStudyProgramm;
import com.example.ymo.service.CreatorStudyProgrammService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/creator_study_programm")
public class CreatorStudyProgrammController {
    @Autowired
    CreatorStudyProgrammService creatorStudyProgrammService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(creatorStudyProgrammService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Integer id ) {
        try {
            return ResponseEntity.ok(creatorStudyProgrammService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody CreatorStudyProgramm creatorStudyProgramm, @RequestParam Integer studyProgrammId) {
        try {
            return ResponseEntity.ok(creatorStudyProgrammService.add(creatorStudyProgramm, studyProgrammId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(creatorStudyProgrammService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
