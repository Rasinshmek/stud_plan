package com.example.ymo.controller;

import com.example.ymo.entity.GroupUnit;
import com.example.ymo.service.GroupUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group_units")
public class GroupUnitController {
    @Autowired
    GroupUnitService groupUnitService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(groupUnitService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(groupUnitService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createGroupUnit(@RequestBody GroupUnit groupUnit, @RequestParam Integer groupComponentsId) {
        try {
            return ResponseEntity.ok(groupUnitService.add(groupUnit, groupComponentsId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(groupUnitService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
