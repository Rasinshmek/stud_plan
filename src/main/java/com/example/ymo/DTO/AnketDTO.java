package com.example.ymo.DTO;

public class AnketDTO{

    private String group;
    private int year;
    private String speciality;
    private int course;
    private int studentCount;
    private int numberFLow;

    public AnketDTO(String group, int year, String speciality, int course, int studentCount, int numberFLow) {
        this.group = group;
        this.year = year;
        this.speciality = speciality;
        this.course = course;
        this.studentCount = studentCount;
        this.numberFLow = numberFLow;
    }

    public int getNumberFLow() {
        return numberFLow;
    }

    public String getGroup() {
        return group;
    }

    public int getYear() {
        return year;
    }

    public String getSpeciality() {
        return speciality;
    }

    public int getCourse() {
        return course;
    }

    public int getStudentCount() {
        return studentCount;
    }
}
