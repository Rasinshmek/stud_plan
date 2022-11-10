package com.example.ymo.service;

import com.example.ymo.entity.GroupComponent;
import com.example.ymo.entity.GroupUnit;
import com.example.ymo.entity.Node;
import com.example.ymo.repository.GroupComponentRepo;
import com.example.ymo.repository.GroupUnitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupUnitService {
    @Autowired
    GroupUnitRepo groupUnitRepo;
    @Autowired
    GroupComponentRepo groupComponentRepo;
    @Autowired
    NodeService nodeService;

    public GroupUnit add(GroupUnit groupUnit, Integer groupComponentsId) {
        GroupComponent groupComponent = groupComponentRepo.findById(groupComponentsId).get();
        groupUnit.setIdGroupComponents(groupComponent);
        return groupUnitRepo.save(groupUnit);
    }

    public Iterable<GroupUnit> getAll() {
        return groupUnitRepo.findAll();
    }

    public GroupUnit getOne(Integer id) {
        GroupUnit groupUnit = groupUnitRepo.findById(id).get();
        return groupUnit;
    }

    public Iterable<GroupUnit> getGroupUnitsPlanId(Integer id) {
        Iterable<Node> nodef = nodeService.getForOnePlan(id);
        List<GroupUnit> list = new ArrayList<GroupUnit>();
        for (Node n : nodef) {
            if(!list.contains(n.getIdSubject().getIdUnit()))
            list.add(n.getIdSubject().getIdUnit());
        }
        return list;
    }

    public Integer delete(Integer id) {
        groupUnitRepo.deleteById(id);
        return id;
    }
}