package com.example.ymo.service;
import com.example.ymo.entity.Plan;
import com.example.ymo.entity.Speciality;
import com.example.ymo.entity.StudyProgramm;
import com.example.ymo.repository.PlanRepo;
import com.example.ymo.repository.SpecialityRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PlanService {
    @Autowired
    PlanRepo planRepo;
    @Autowired
    SpecialityRepo specialityRepo;
    public Plan add(Plan plan, Integer specialityId )
    {
        Speciality speciality = specialityRepo.findById(specialityId).get();
        JSONObject json = new JSONObject(plan);
        LocalDate enrollmentYear = LocalDate.parse(json.getString("enrollmentYear"));
        LocalDate utv_date = LocalDate.parse(json.getString("utvDate"));
        plan.setEnrollmentYear(utv_date);
        plan.setEnrollmentYear(enrollmentYear);
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
    public Integer delete(Integer id) {
        planRepo.deleteById(id);
        return id;
    }


}
