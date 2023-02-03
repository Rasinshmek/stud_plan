package com.example.ymo.service;
import com.example.ymo.entity.WeeksSemestr;
import com.example.ymo.entity.Plan;
import com.example.ymo.repository.WeeksSemestrRepo;
import com.example.ymo.repository.PlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeeksSemestrService {
    @Autowired
    WeeksSemestrRepo weeksSemestrRepo;
    @Autowired
    PlanRepo planRepo;

    public WeeksSemestr add(WeeksSemestr weeksSemestr, Integer planId) {
        Plan plan = planRepo.findById(planId).get();
        weeksSemestr.setIdPlan(plan);
        return weeksSemestrRepo.save(weeksSemestr);
    }

    public Iterable<WeeksSemestr> getAll() {
        return weeksSemestrRepo.findAll();
    }

    public WeeksSemestr getOne(Integer id) {
        WeeksSemestr weeksSemestr = weeksSemestrRepo.findById(id).get();
        return weeksSemestr;
    }
    public Iterable<WeeksSemestr> getForOnePlan(Integer planId) {
        List<WeeksSemestr> all = (List) weeksSemestrRepo.findAll();
        List<WeeksSemestr> filtred = all.stream().filter(p->p.getIdPlan().getId().equals(planId)).collect(Collectors.toList());
        return filtred;
    }
    public Integer delete(Integer id) {
        weeksSemestrRepo.deleteById(id);
        return id;
    }


}
