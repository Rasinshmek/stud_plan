package com.example.ymo.service;
import com.example.ymo.entity.CreatorStudyProgramm;
import com.example.ymo.entity.Node;

import com.example.ymo.entity.Semestr;
import com.example.ymo.repository.NodeRepo;
import com.example.ymo.repository.SemestrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemestrService {
    @Autowired
    SemestrRepo semestrRepo ;
    @Autowired
    NodeRepo nodeRepo;
    public Semestr add(Semestr semestr, Integer nodeId)
    {
        Node node = nodeRepo.findById(nodeId).get();
        semestr.setNode(node);
        return semestrRepo.save(semestr);
    }
    public Iterable<Semestr> getAll()
    {
        return semestrRepo.findAll();
    }

    public Semestr getOne(Integer id)
    {
        Semestr semestr = semestrRepo.findById(id).get();
        return semestr;
    }
    public Integer delete(Integer id) {
        semestrRepo.deleteById(id);
        return id;
    }


}