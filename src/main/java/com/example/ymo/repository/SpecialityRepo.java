package com.example.ymo.repository;


import com.example.ymo.entity.Speciality;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecialityRepo extends CrudRepository<Speciality, Integer> {
    List<Speciality> findByShifr(String shifr);
}
