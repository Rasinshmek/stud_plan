package com.example.ymo.service;

import com.example.ymo.entity.Competence;
import com.example.ymo.repository.CompetenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetenceService {

    @Autowired
    CompetenceRepo competenceRepo;

    public  Competence add( Competence competence) {
        return competenceRepo.save(competence);
    }

    public Iterable<Competence> getAll() {
        return competenceRepo.findAll();
    }

    public Competence getOne(Integer id) {
        Competence competence = competenceRepo.findById(id).get();
        return competence;
    }

    public Integer delete(Integer id) {
        competenceRepo.deleteById(id);
        return id;
    }


}
