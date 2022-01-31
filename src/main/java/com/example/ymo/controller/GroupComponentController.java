package com.example.ymo.controller;

import com.example.ymo.entity.GroupComponent;
import com.example.ymo.service.GroupComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group_components")
public class GroupComponentController {
    @Autowired
    GroupComponentService groupComponentService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(groupComponentService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(groupComponentService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody GroupComponent groupComponent) {
        try {
            return ResponseEntity.ok(groupComponentService.add( groupComponent));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(groupComponentService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
