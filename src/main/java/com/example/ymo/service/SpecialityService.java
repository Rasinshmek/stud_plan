package com.example.ymo.service;

import com.example.ymo.entity.Diplom;
import com.example.ymo.entity.Speciality;
import com.example.ymo.repository.SpecialityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialityService {

    @Autowired
    SpecialityRepo specialityRepo;

    public  Speciality add(Speciality speciality) {
        return specialityRepo.save(speciality);
    }

    public Iterable<Speciality> getAll() {
        return specialityRepo.findAll();
    }

    public Speciality getOne(Integer id) {
        Speciality speciality = specialityRepo.findById(id).get();
        return speciality;
    }

    public Integer delete(Integer id) {
        specialityRepo.deleteById(id);
        return id;
    }


}
