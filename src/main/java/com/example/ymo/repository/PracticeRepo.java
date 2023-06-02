package com.example.ymo.repository;


import com.example.ymo.entity.Plan;
import com.example.ymo.entity.Practice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PracticeRepo extends CrudRepository<Practice, Integer> {
    List<Practice> findByIdPlanAndIdSemestr(Plan idPlan, Integer idSemestr);
}
