package com.example.ymo.controller;

import com.example.ymo.DTO.Nagruzka;
import com.example.ymo.service.NagruzkaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nagruzka")
@Api(description = "Контроллер для нагрузки")
public class NagruzkaController {
    @Autowired
    NagruzkaService nagruzkaService;

    @GetMapping("")
    @ApiOperation("Получить нагрузку")
    public ResponseEntity getNagruzka() {
        try {
            return ResponseEntity.ok(nagruzkaService.getNagruzka());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
