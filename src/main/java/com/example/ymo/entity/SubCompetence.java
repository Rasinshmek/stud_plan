package com.example.ymo.entity;

import javax.persistence.*;

@Entity
@Table(name = "sub_competence")
public class SubCompetence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_competence")
    private Competence idCompetence;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject idSubject;

    public Subject getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Subject idSubject) {
        this.idSubject = idSubject;
    }

    public Competence getIdCompetence() {
        return idCompetence;
    }

    public void setIdCompetence(Competence idCompetence) {
        this.idCompetence = idCompetence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}