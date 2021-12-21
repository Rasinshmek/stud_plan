package com.example.ymo.model;

import javax.persistence.*;

@Entity
@Table(name = "node")
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject idSubject;

    @Column(name = "id_cathedra")
    private Integer idCathedra;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan idPlan;

    public Plan getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Plan idPlan) {
        this.idPlan = idPlan;
    }

    public Integer getIdCathedra() {
        return idCathedra;
    }

    public void setIdCathedra(Integer idCathedra) {
        this.idCathedra = idCathedra;
    }

    public Subject getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Subject idSubject) {
        this.idSubject = idSubject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}