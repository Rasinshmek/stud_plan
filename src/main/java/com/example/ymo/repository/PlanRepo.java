package com.example.ymo.repository;

import com.example.ymo.entity.Plan;
import com.example.ymo.entity.Speciality;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public interface PlanRepo extends CrudRepository<Plan, Integer> {
    List<Plan> findByidSpeciality(String idSpeciality);
    List<Plan> findByEnrollmentYearAfterAndIdSpeciality(LocalDate enrollmentYear, Speciality speciality);

}
