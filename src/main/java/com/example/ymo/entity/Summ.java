package com.example.ymo.entity;

public class Summ {
    public Summ() {
    }
    public int allLecture=0;
    public int allLaboratory=0;
    public int allPractice=0;
    public int allSeminar=0;
    public int allZe=0;

    public void lectureAdd(int value)
    {
        allLecture+=value;
    }
    public void laboratoryAdd(int value)
    {
        allLaboratory+=value;
    }
    public void practiceAdd(int value)
    {
        allPractice+=value;
    }
    public void seminarAdd(int value)
    {
        allSeminar+=value;
    }
    public void ZeAdd(int value)
    {
        allZe+=value;
    }

}
