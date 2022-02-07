package com.example.ymo.service;
import com.example.ymo.entity.Diplom;
import com.example.ymo.entity.Plan;
import com.example.ymo.entity.Speciality;
import com.example.ymo.repository.DiplomRepo;
import com.example.ymo.repository.PlanRepo;
import com.example.ymo.repository.SpecialityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService {
    @Autowired
    PlanRepo planRepo;
    @Autowired
    SpecialityRepo specialityRepo;
    @Autowired
    DiplomRepo diplomRepo;
    public Plan add(Plan plan, Integer specialityId )
    {
        Speciality speciality = specialityRepo.findById(specialityId).get();
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
