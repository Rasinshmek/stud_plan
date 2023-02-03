package com.example.ymo.service;

import com.example.ymo.entity.Competence;
import com.example.ymo.entity.Node;
import com.example.ymo.entity.Semestr;
import com.example.ymo.entity.SubCompetence;
import com.example.ymo.repository.CompetenceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompetenceService {

    @Autowired
    CompetenceRepo competenceRepo;
    @Autowired
    NodeService nodeService;
    @Autowired
    SubCompetenceService subCompetenceService;

    public Competence add(Competence competence) {
        return competenceRepo.save(competence);
    }

    public Iterable<Competence> getAll() {
        return competenceRepo.findAll();
    }

    public Competence getOne(Integer id) {
        Competence competence = competenceRepo.findById(id).get();
        return competence;
    }

    public Iterable<Competence> getForOnePlan(Integer planId) {
        Iterable<Node> list = nodeService.getForOnePlan(planId);
        Iterable<SubCompetence> listSub = subCompetenceService.getAll();
        List<Competence> rez = new ArrayList<Competence>();
        for (Node n : list) {
            for (SubCompetence sub : listSub) {
                if( sub.getIdSubject().getId().equals(n.getIdSubject().getId()))
                rez.add(sub.getIdCompetence());
            }
        }
        return rez.stream().distinct().collect(Collectors.toList());
    }

    public Integer delete(Integer id) {
        competenceRepo.deleteById(id);
        return id;
    }


}
