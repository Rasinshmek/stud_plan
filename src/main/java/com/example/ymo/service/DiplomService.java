package com.example.ymo.service;

import com.example.ymo.entity.Diplom;
import com.example.ymo.repository.DiplomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiplomService {

    @Autowired
    DiplomRepo DiplomRepo;

    public Diplom add(Diplom diplom) {
        return DiplomRepo.save(diplom);
    }

    public Iterable<Diplom> getAll() {
        return DiplomRepo.findAll();
    }

    public Diplom getOne(Integer id) {
        Diplom diplom = DiplomRepo.findById(id).get();
        return diplom;
    }

    public Integer delete(Integer id) {
        DiplomRepo.deleteById(id);
        return id;
    }


}
