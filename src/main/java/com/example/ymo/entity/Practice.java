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

    @Column(name = "ze")
    private Integer ze;

    @Column(name = "type", length = 30)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getZe() {
        return ze;
    }

    public void setZe(Integer ze) {
        this.ze = ze;
    }

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