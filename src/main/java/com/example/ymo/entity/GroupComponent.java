package com.example.ymo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group_components")
public class GroupComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "name")
    private String name;

    @Column(name = "component_number", length = 10)
    private String componentNumber;

    public String getComponentNumber() {
        return componentNumber;
    }

    public void setComponentNumber(String componentNumber) {
        this.componentNumber = componentNumber;
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