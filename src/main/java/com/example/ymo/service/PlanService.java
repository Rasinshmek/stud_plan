package com.example.ymo.service;
import com.example.ymo.entity.*;
import com.example.ymo.repository.PlanRepo;
import com.example.ymo.repository.SemestrRepo;
import com.example.ymo.repository.SpecialityRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlanService {
    @Autowired
    PlanRepo planRepo;
    @Autowired
    SemestrRepo semestrRepo;
    @Autowired
    SpecialityRepo specialityRepo;
    public Plan add(Plan plan, Integer specialityId )
    {
        Speciality speciality = specialityRepo.findById(specialityId).get();
        JSONObject json = new JSONObject(plan);
        LocalDate utv_date = LocalDate.parse(json.getString("utvDate"));
        plan.setEnrollmentYear(utv_date);
         plan.setIdSpeciality(speciality);
        return planRepo.save(plan);
    }
    public Iterable<Plan> getAll()
    {
       return planRepo.findAll();
    }

    public Plan getOne(Integer id)
    {
        Plan plan = planRepo.findById(id).get();
        return plan;
    }
    public Summ getSumm(Integer id)
    {
        List<Semestr> all= (List)semestrRepo.findAll();
        List<Semestr> filtred=all.stream().filter(s->s.getIdNode().getIdPlan().getId().equals(id)).collect(Collectors.toList());
        Summ summ=new Summ();
        for (Semestr sem:filtred) {
        summ.lectureAdd(sem.getLecture());
            summ.laboratoryAdd(sem.getLaboratory());
            summ.practiceAdd(sem.getPractice());
            summ.seminarAdd(sem.getSeminar());
        }
        return summ;
    }
    public Integer delete(Integer id) {
        planRepo.deleteById(id);
        return id;
    }


}
