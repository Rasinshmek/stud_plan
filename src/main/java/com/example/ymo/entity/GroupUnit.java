package com.example.ymo.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "group_units")
public class GroupUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;
   // @OneToMany(mappedBy = "idUnit")
   // private List<Subject> subjects;
    @ManyToOne
    @JoinColumn(name = "id_group_components")
    private GroupComponent idGroupComponents;

    @Column(name = "unit_number", length = 10)
    private String unitNumber;

    @Column(name = "group_unitscol", length = 45)
    private String groupUnitscol;

    @Column(name = "id_plana")
    private Integer idPlana;

    public Integer getIdPlana() {
        return idPlana;
    }

    public void setIdPlana(Integer idPlana) {
        this.idPlana = idPlana;
    }

    public String getGroupUnitscol() {
        return groupUnitscol;
    }

    public void setGroupUnitscol(String groupUnitscol) {
        this.groupUnitscol = groupUnitscol;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public GroupComponent getIdGroupComponents() {
        return idGroupComponents;
    }

    public void setIdGroupComponents(GroupComponent idGroupComponents) {
        this.idGroupComponents = idGroupComponents;
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

  //  public Iterable<Subject> getSubjects() {return subjects;}

   // public void setSubjects(List<Subject> subjects) {
   //     this.subjects = subjects;
   // }
}