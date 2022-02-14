package com.example.ymo.service;

import com.example.ymo.entity.Fakultativ;
import com.example.ymo.entity.Plan;
import com.example.ymo.repository.FakultativRepo;
import com.example.ymo.repository.PlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FakultativService {
    @Autowired
    FakultativRepo fakultativRepo;
    @Autowired
    PlanRepo planRepo;

    public Fakultativ add(Fakultativ fakultativ, Integer planId) {
        Plan plan = planRepo.findById(planId).get();
        fakultativ.setIdPlan(plan);
        return fakultativRepo.save(fakultativ);
    }

    public Iterable<Fakultativ> getAll() {
        return fakultativRepo.findAll();
    }

    public Fakultativ getOne(Integer id) {
        Fakultativ fakultativ = fakultativRepo.findById(id).get();
        return fakultativ;
    }

    public Integer delete(Integer id) {
        fakultativRepo.deleteById(id);
        return id;
    }


}
