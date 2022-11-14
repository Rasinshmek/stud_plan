package com.example.ymo.entity;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "shifr", length = 50)
    private String shifr;

    @ManyToOne
    @JoinColumn(name = "id_unit")
    private GroupUnit idUnit;

    public GroupUnit getIdUnit() {
        return idUnit;
    }

    public void setIdUnit(GroupUnit idUnit) {
        this.idUnit = idUnit;
    }

    public String getShifr() {
        return shifr;
    }

    public void setShifr(String shifr) {
        this.shifr = shifr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}