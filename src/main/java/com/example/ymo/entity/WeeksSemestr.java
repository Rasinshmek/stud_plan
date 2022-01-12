package com.example.ymo.entity;

import javax.persistence.*;

@Entity
@Table(name = "weeks_semestr")
public class WeeksSemestr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number_semestr")
    private Integer numberSemestr;

    @Column(name = "count_weeks")
    private Integer countWeeks;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan idPlan;

    public Plan getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Plan idPlan) {
        this.idPlan = idPlan;
    }

    public Integer getCountWeeks() {
        return countWeeks;
    }

    public void setCountWeeks(Integer countWeeks) {
        this.countWeeks = countWeeks;
    }

    public Integer getNumberSemestr() {
        return numberSemestr;
    }

    public void setNumberSemestr(Integer numberSemestr) {
        this.numberSemestr = numberSemestr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}