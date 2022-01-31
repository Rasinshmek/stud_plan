package com.example.ymo.service;

import com.example.ymo.entity.GroupComponent;
import com.example.ymo.repository.GroupComponentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupComponentService {

    @Autowired
    GroupComponentRepo groupComponentRepo;

    public  GroupComponent add( GroupComponent groupUnit) {
        return groupComponentRepo.save(groupUnit);
    }

    public Iterable<GroupComponent> getAll() {
        return groupComponentRepo.findAll();
    }

    public GroupComponent getOne(Integer id) {
        GroupComponent groupComponent = groupComponentRepo.findById(id).get();
        return groupComponent;
    }

    public Integer delete(Integer id) {
        groupComponentRepo.deleteById(id);
        return id;
    }


}
