package com.example.ymo.controller;

import com.example.ymo.entity.GroupUnit;
import com.example.ymo.service.GroupUnitService;
import io.swagger.annotations.ApiOperation;
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
    @GetMapping("/planId/{id}")
    @ApiOperation("Получить модули по id плана")
    public ResponseEntity getGroupUnitsPlanId(@PathVariable Integer id ) {
        try {
            return ResponseEntity.ok(groupUnitService.getGroupUnitsPlanId(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Integer id ) {
        try {
            return ResponseEntity.ok(groupUnitService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody GroupUnit groupUnit, @RequestParam Integer groupComponentsId) {
        try {
            return ResponseEntity.ok(groupUnitService.add(groupUnit, groupComponentsId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(groupUnitService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
