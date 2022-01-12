package com.example.ymo.entity;

import javax.persistence.*;

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