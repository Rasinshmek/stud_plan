package com.example.ymo.controller;

import com.example.ymo.entity.Semestr;
import com.example.ymo.repository.SemestrRepo;
import com.example.ymo.service.SemestrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/semestr")
public class SemestrController {
    @Autowired
    private SemestrService semService;
    @PostMapping
    public ResponseEntity addSemestr(@RequestBody Semestr sem, @RequestParam Integer id_node)
    {
        try {
            semService.addSemestr(sem, id_node);
            return ResponseEntity.ok("Семестр сохранён");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity getOneSemestrById(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(semService.getOneSemetrById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
