package com.example.ymo.service;


import com.example.ymo.entity.Node;
import com.example.ymo.entity.Plan;
import com.example.ymo.entity.Subject;
import com.example.ymo.repository.NodeRepo;
import com.example.ymo.repository.PlanRepo;
import com.example.ymo.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeService {
    @Autowired
    NodeRepo nodeRepo;
    @Autowired
    PlanRepo planRepo;
    @Autowired
    SubjectRepo subjectRepo;
    public Node add(Node node, Integer planId, Integer subjectId )
    {
        Plan plan = planRepo.findById(planId).get();
        node.setIdPlan(plan);
        Subject subject = subjectRepo.findById(subjectId).get();
        node.setIdSubject(subject);
        return nodeRepo.save(node);
    }
    public Iterable<Node> getAll()
    {
        return nodeRepo.findAll();
    }

    public Node getOne(Integer id)
    {
        Node node = nodeRepo.findById(id).get();
        return node;
    }
    public Integer delete(Integer id) {
        nodeRepo.deleteById(id);
        return id;
    }

}
