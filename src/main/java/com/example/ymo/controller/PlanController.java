package com.example.ymo.controller;

import com.example.ymo.entity.Plan;
import com.example.ymo.service.PlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/plan")
@Api(description = "Контроллер для плана")
public class PlanController {
    @Autowired
    PlanService planService;

    @GetMapping
    @ApiOperation("Получить все планы")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(planService.getAll());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ApiOperation("Получить план по id")
    public ResponseEntity getOne(@PathVariable Integer id ) {
        try {
            return ResponseEntity.ok(planService.getOne(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    @GetMapping("/{id}/summ")
    @ApiOperation("Получить суммы по плану id")
    public ResponseEntity getSumm(@PathVariable Integer id ) {
        try {
            return ResponseEntity.ok(planService.getSumm(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    @PostMapping
    @ApiOperation("Добавление и обновление плана")
    public ResponseEntity create(@RequestBody Plan plan, @RequestParam Integer specialityId) {
        try {
            return ResponseEntity.ok(planService.add(plan, specialityId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удалить план по id")
    public ResponseEntity delete(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(planService.delete(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
