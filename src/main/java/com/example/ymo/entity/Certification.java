package com.example.ymo.entity;

import javax.persistence.*;

@Entity
@Table(name = "certification")
public class Certification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan idPlan;

    public Plan getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Plan idPlan) {
        this.idPlan = idPlan;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}