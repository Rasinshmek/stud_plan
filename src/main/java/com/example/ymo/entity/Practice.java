package com.example.ymo.entity;

import javax.persistence.*;

@Entity
@Table(name = "practice")
public class Practice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan idPlan;

    @Column(name = "id_semestr")
    private Integer idSemestr;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "count_week")
    private Integer countWeek;

    public Integer getCountWeek() {
        return countWeek;
    }

    public void setCountWeek(Integer countWeek) {
        this.countWeek = countWeek;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdSemestr() {
        return idSemestr;
    }

    public void setIdSemestr(Integer idSemestr) {
        this.idSemestr = idSemestr;
    }

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