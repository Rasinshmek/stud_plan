package com.example.ymo.repository;

import com.example.ymo.entity.Node;
import com.example.ymo.entity.Semestr;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SemestrRepo extends CrudRepository<Semestr, Integer> {
    List<Semestr> findByIdNodeAndNumber(Node node, int number);


}
