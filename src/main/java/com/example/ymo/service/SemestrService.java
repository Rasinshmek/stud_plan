package com.example.ymo.service;

import com.example.ymo.entity.Node;
import com.example.ymo.entity.Semestr;
import com.example.ymo.repository.NodeRepo;
import com.example.ymo.repository.SemestrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemestrService {
    @Autowired
    private SemestrRepo semRepo;
    @Autowired
    private NodeRepo nodeRepo;
    public Semestr addSemestr(Semestr sem, Integer id_node) {
      Node node = nodeRepo.findById(id_node).get();
      sem.setNode(node);
      return semRepo.save(sem);
    }
    public Semestr getOneSemetrById(Integer id) throws Exception {
        Semestr sem = semRepo.findById(id).get();
        if(sem==null)
        {
            throw new Exception("Семестра с таким ID не существует");
        }
            return sem;
    }

}
