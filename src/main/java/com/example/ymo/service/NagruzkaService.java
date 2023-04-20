package com.example.ymo.service;

import com.example.ymo.DTO.Nagruzka;
import com.example.ymo.entity.Plan;
import com.example.ymo.repository.PlanRepo;
import com.example.ymo.repository.SemestrRepo;
import com.example.ymo.repository.SpecialityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class NagruzkaService {
    @Autowired
    PlanRepo planRepo;
    @Autowired
    SemestrRepo semestrRepo;
    @Autowired
    SpecialityRepo specialityRepo;


    public List<Nagruzka> getNagruzka()
    {
        List<Nagruzka> nagr= new ArrayList<Nagruzka>();

        return nagr;
    }



}
