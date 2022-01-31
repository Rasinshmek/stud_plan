package com.example.ymo.service;

import com.example.ymo.entity.Node;
import com.example.ymo.entity.Semestr;
import com.example.ymo.repository.NodeRepo;
import com.example.ymo.repository.SemestrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeService {
    @Autowired
    private NodeRepo nodeRepo;
    @Autowired
    private SemestrRepo semRepo;
    public Node addNode(Node node) {
        return nodeRepo.save(node);
    }
    public Node getOneNodeById(Integer id) throws Exception {
        Node node = nodeRepo.findById(id).get();
        if(node==null)
        {
            throw new Exception("Ноды с таким ID не существует");
        }
        return node;
    }
}
