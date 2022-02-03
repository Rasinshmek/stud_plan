package com.example.ymo.service;

import com.example.ymo.entity.Competence;
import com.example.ymo.repository.CompetenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetenceService {

    @Autowired
    CompetenceRepo competenceRepo;

    public  Competence add( Competence groupUnit) {
        return competenceRepo.save(groupUnit);
    }

    public Iterable<Competence> getAll() {
        return competenceRepo.findAll();
    }

    public Competence getOne(Integer id) {
        Competence groupComponent = competenceRepo.findById(id).get();
        return groupComponent;
    }

    public Integer delete(Integer id) {
        competenceRepo.deleteById(id);
        return id;
    }


}
