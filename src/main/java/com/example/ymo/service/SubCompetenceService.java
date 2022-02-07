package com.example.ymo.service;
import com.example.ymo.entity.Competence;
import com.example.ymo.entity.SubCompetence;
import com.example.ymo.entity.Subject;
import com.example.ymo.repository.CompetenceRepo;
import com.example.ymo.repository.SubCompetenceRepo;
import com.example.ymo.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCompetenceService {
    @Autowired
    SubCompetenceRepo subCompetenceRepo;
    @Autowired
    CompetenceRepo competenceRepo;
    @Autowired
    SubjectRepo subjectRepo;
    public SubCompetence add(SubCompetence subCompetence, Integer competenceId, Integer subjectId )
    {
        Competence competence = competenceRepo.findById(competenceId).get();
        subCompetence.setIdCompetence(competence);
        Subject subject = subjectRepo.findById(subjectId).get();
        subCompetence.setIdSubject(subject);
        return subCompetenceRepo.save(subCompetence);
    }
    public Iterable<SubCompetence> getAll()
    {
       return subCompetenceRepo.findAll();
    }

    public SubCompetence getOne(Integer id)
    {
        SubCompetence subCompetence = subCompetenceRepo.findById(id).get();
        return subCompetence;
    }
    public Integer delete(Integer id) {
        subCompetenceRepo.deleteById(id);
        return id;
    }


}
