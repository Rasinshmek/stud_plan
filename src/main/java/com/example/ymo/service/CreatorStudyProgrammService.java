package com.example.ymo.service;
import com.example.ymo.entity.CreatorStudyProgramm;
import com.example.ymo.entity.StudyProgramm;
import com.example.ymo.repository.CreatorStudyProgrammRepo;
import com.example.ymo.repository.StudyProgrammRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatorStudyProgrammService {
    @Autowired
    CreatorStudyProgrammRepo creatorStudyProgrammRepo ;
    @Autowired
    StudyProgrammRepo studyProgrammRepo;
    public CreatorStudyProgramm add(CreatorStudyProgramm creatorStudyProgramm, Integer studyProgrammId)
    {
        StudyProgramm studyProgramm = studyProgrammRepo.findById(studyProgrammId).get();
        creatorStudyProgramm.setIdStudyProgramm(studyProgramm);
        return creatorStudyProgrammRepo.save(creatorStudyProgramm);
    }
    public Iterable<CreatorStudyProgramm> getAll()
    {
       return creatorStudyProgrammRepo.findAll();
    }

    public CreatorStudyProgramm getOne(Integer id)
    {
        CreatorStudyProgramm creatorStudyProgramm = creatorStudyProgrammRepo.findById(id).get();
        return creatorStudyProgramm;
    }
    public Integer delete(Integer id) {
        creatorStudyProgrammRepo.deleteById(id);
        return id;
    }


}
