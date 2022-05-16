package com.example.ymo.service;
import com.example.ymo.entity.StudyProgramm;
import com.example.ymo.entity.Subject;
import com.example.ymo.repository.StudyProgrammRepo;
import com.example.ymo.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Service
public class StudyProgrammService {
    @Autowired
    StudyProgrammRepo studyProgrammRepo;

    @Autowired
    SubjectRepo subjectRepo ;

    public StudyProgramm add(StudyProgramm resp, Integer subjectId)
    {   JSONObject json = new JSONObject(resp);
        LocalDate date = LocalDate.parse(json.getString("dateApprove"));
        StudyProgramm studyProgramm = new StudyProgramm();
        studyProgramm.setId(json.getInt("id"));
        studyProgramm.setDateApprove(date);
        Subject subject = subjectRepo.findById(subjectId).get();
        studyProgramm.setIdSubject(subject);
        return studyProgrammRepo.save(studyProgramm);
    }
    public Iterable<StudyProgramm> getAll()
    {
       return studyProgrammRepo.findAll();
    }

    public StudyProgramm getOne(Integer id)
    {
        StudyProgramm studyProgramm = studyProgrammRepo.findById(id).get();
        return studyProgramm;
    }
    public Integer delete(Integer id) {
        studyProgrammRepo.deleteById(id);
        return id;
    }


}
