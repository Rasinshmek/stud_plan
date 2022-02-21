package com.example.ymo.controller;

import com.example.ymo.entity.Node;
import com.example.ymo.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/node")
public class NodeController {
    @Autowired
    NodeService nodeService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(nodeService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Integer id ) {
        try {
            return ResponseEntity.ok(nodeService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Node node, @RequestParam Integer planId, @RequestParam Integer subjectId) {
        try {
            return ResponseEntity.ok(nodeService.add(node, planId,subjectId ));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(nodeService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
