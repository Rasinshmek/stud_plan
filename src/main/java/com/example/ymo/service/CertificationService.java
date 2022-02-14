package com.example.ymo.service;

import com.example.ymo.entity.Certification;
import com.example.ymo.entity.Plan;
import com.example.ymo.repository.CertificationRepo;
import com.example.ymo.repository.PlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CertificationService {
    @Autowired
    CertificationRepo certificationRepo;
    @Autowired
    PlanRepo planRepo;

    public Certification add(Certification certification, Integer planId) {
        Plan plan = planRepo.findById(planId).get();
        certification.setIdPlan(plan);
        return certificationRepo.save(certification);
    }

    public Iterable<Certification> getAll() {
        return certificationRepo.findAll();
    }

    public Certification getOne(Integer id) {
        Certification certification = certificationRepo.findById(id).get();
        return certification;
    }

    public Integer delete(Integer id) {
        certificationRepo.deleteById(id);
        return id;
    }


}
