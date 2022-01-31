package com.example.ymo.repository;

import com.example.ymo.entity.Semestr;
import org.springframework.data.repository.CrudRepository;

public interface SemestrRepo extends CrudRepository <Semestr,Integer> {
    Semestr findByNumber (Integer number);
}
