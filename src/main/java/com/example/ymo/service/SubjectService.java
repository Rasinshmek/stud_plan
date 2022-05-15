package com.example.ymo.service;

import com.example.ymo.entity.GroupUnit;
import com.example.ymo.entity.Subject;
import com.example.ymo.repository.GroupUnitRepo;
import com.example.ymo.repository.SpecialityRepo;
import com.example.ymo.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    @Autowired
    SubjectRepo subjectRepo;
    @Autowired
    GroupUnitRepo groupUnitRepo;
    public Subject add(Subject subject, Integer unitid )
    {
        GroupUnit groupUnit = groupUnitRepo.findById(unitid).get();
        subject.setIdUnit(groupUnit);
        return subjectRepo.save(subject);
    }
    public Iterable<Subject> getAll()
    {
        return subjectRepo.findAll();
    }

    public Subject getOne(Integer id)
    {
        Subject subject = subjectRepo.findById(id).get();
        return subject;
    }
    public Integer delete(Integer id) {
        subjectRepo.deleteById(id);
        return id;
    }


}
