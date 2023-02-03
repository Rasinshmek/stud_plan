package com.example.ymo.service;

import com.example.ymo.entity.Plan;
import com.example.ymo.entity.Practice;
import com.example.ymo.repository.PlanRepo;
import com.example.ymo.repository.PracticeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PracticeService {
    @Autowired
    PracticeRepo practiceRepo;
    @Autowired
    PlanRepo planRepo;

    public Practice add(Practice practice, Integer planId) {
        Plan plan = planRepo.findById(planId).get();
        practice.setIdPlan(plan);
        return practiceRepo.save(practice);
    }

    public Iterable<Practice> getAll() {
        return practiceRepo.findAll();
    }

    public Practice getOne(Integer id) {
        Practice practice = practiceRepo.findById(id).get();
        return practice;
    }

    public Iterable<Practice> getForOnePlan(Integer planId) {
        List<Practice> all = (List) practiceRepo.findAll();
        List<Practice> filtred = all.stream().filter(p->p.getIdPlan().getId().equals(planId)).collect(Collectors.toList());
        return filtred;
    }

    public Integer delete(Integer id) {
        practiceRepo.deleteById(id);
        return id;
    }


}
