package com.example.ymo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnketDTO{

    private String group;
    private int year;
    private String speciality;
    private int course;
    private int studentCount;
    private int numberFLow;
    private int countSubGroup;
}
