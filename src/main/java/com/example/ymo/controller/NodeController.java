package com.example.ymo.controller;

import com.example.ymo.entity.Node;
import com.example.ymo.service.NodeService;
import com.example.ymo.service.SemestrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/node")
public class NodeController {
    @Autowired
    private NodeService nodeService;
    @PostMapping
    public ResponseEntity addNode(@RequestBody Node node)
    {try
     {
        nodeService.addNode(node);
         return ResponseEntity.ok("Нода сохранена");
     }
        catch(Exception ex)
         {
             return ResponseEntity.badRequest().body(ex.getMessage());
         }
    }
    @GetMapping
    public ResponseEntity getOneNodeById(@RequestParam Integer id)
    {
        try
        {
        return ResponseEntity.ok(nodeService.getOneNodeById(id));
        }
        catch(Exception ex)
        {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
