package com.example.ymo.model;

import javax.persistence.*;

@Entity
@Table(name = "group_units")
public class GroupUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_group_components")
    private GroupComponent idGroupComponents;

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
}