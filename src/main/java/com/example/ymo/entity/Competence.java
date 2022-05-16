package com.example.ymo.entity;

import javax.persistence.*;

@Entity
@Table(name = "competence")
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name_competence", length = 100)
    private String nameCompetence;

    @Column(name = "shifr_competence", length = 45)
    private String shifrCompetence;

    public String getShifrCompetence() {
        return shifrCompetence;
    }

    public void setShifrCompetence(String shifrCompetence) {
        this.shifrCompetence = shifrCompetence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCompetence() {
        return nameCompetence;
    }

    public void setNameCompetence(String name) {
        this.nameCompetence = nameCompetence;
    }
}