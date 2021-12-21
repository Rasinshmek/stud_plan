package com.example.ymo.model;

import javax.persistence.*;

@Entity
@Table(name = "creator_study_programm")
public class CreatorStudyProgramm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_teacher")
    private Integer idTeacher;

    @ManyToOne
    @JoinColumn(name = "id_study_programm")
    private StudyProgramm idStudyProgramm;

    public StudyProgramm getIdStudyProgramm() {
        return idStudyProgramm;
    }

    public void setIdStudyProgramm(StudyProgramm idStudyProgramm) {
        this.idStudyProgramm = idStudyProgramm;
    }

    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}