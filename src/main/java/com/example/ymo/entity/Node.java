package com.example.ymo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "node")
public class Node {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer idNode;
    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject idSubject;

    @Column(name = "id_cathedra")
    private Integer idCathedra;

    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan idPlan;

    @Column(name = "node_number", length = 10)
    private String nodeNumber;

    public String getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(String nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

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

    public Integer getIdNode() {
        return idNode;
    }

    public void setIdNode(Integer id) {this.idNode = idNode;}
}