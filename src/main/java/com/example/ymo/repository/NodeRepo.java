package com.example.ymo.repository;

import com.example.ymo.entity.Node;
import com.example.ymo.entity.Plan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NodeRepo extends CrudRepository<Node, Integer> {
    List<Node> findByIdPlan(Plan id_plan);
}
