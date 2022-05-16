package com.example.ymo.entity;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_speciality")
    private Speciality idSpeciality;

    @Column(name = "diplom_name", length = 100)
    private String diplomName;

    @Column(name = "diplom_id_semestr")
    private Integer diplomIdSemestr;

    @Column(name = "diplom_count_week")
    private Integer diplomCountWeek;

    @Column(name = "diplom_ze")
    private Integer diplomZe;

    @Column(name = "enrollment_year")
    private LocalDate enrollmentYear;

    @Column(name = "reg_number", length = 15)
    private String regNumber;

    @Column(name = "utv_date")
    private LocalDate utvDate;

    @Column(name = "learn_year", length = 45)
    private String learnYear;

    @Lob
    @Column(name = "education_form")
    private String educationForm;

    @Column(name = "GovExam")
    private Integer govExam;

    public Integer getGovExam() {
        return govExam;
    }

    public void setGovExam(Integer govExam) {
        this.govExam = govExam;
    }

    public String getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(String educationForm) {
        this.educationForm = educationForm;
    }

    public String getLearnYear() {
        return learnYear;
    }

    public void setLearnYear(String learnYear) {
        this.learnYear = learnYear;
    }

    public LocalDate getUtvDate() {
        return utvDate;
    }

    public void setUtvDate(LocalDate utvDate) {
        this.utvDate = utvDate;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public LocalDate getEnrollmentYear() {
        return enrollmentYear;
    }

    public void setEnrollmentYear(LocalDate enrollmentYear) {
        this.enrollmentYear = enrollmentYear;
    }

    public Integer getDiplomZe() {
        return diplomZe;
    }

    public void setDiplomZe(Integer diplomZe) {
        this.diplomZe = diplomZe;
    }

    public Integer getDiplomCountWeek() {
        return diplomCountWeek;
    }

    public void setDiplomCountWeek(Integer diplomCountWeek) {
        this.diplomCountWeek = diplomCountWeek;
    }

    public Integer getDiplomIdSemestr() {
        return diplomIdSemestr;
    }

    public void setDiplomIdSemestr(Integer diplomIdSemestr) {
        this.diplomIdSemestr = diplomIdSemestr;
    }

    public String getDiplomName() {
        return diplomName;
    }

    public void setName(String diplomName) {
        this.diplomName = diplomName;
    }

    public Speciality getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(Speciality idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}