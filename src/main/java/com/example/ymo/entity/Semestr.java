package com.example.ymo.entity;

import javax.persistence.*;

@Entity
@Table(name = "semestr")
public class Semestr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "lecture")
    private Integer lecture;

    @Column(name = "laboratory")
    private Integer laboratory;

    @Column(name = "practice")
    private Integer practice;

    @Column(name = "seminar")
    private Integer seminar;

    @Lob
    @Column(name = "type")
    private String type;

    @Column(name = "rgr")
    private Integer rgr;

    @Lob
    @Column(name = "course_work_type")
    private String courseWorkType;

    @ManyToOne
    @JoinColumn(name = "id_node")
    private Node idNode;

    @Column(name = "ze")
    private Double ze;

    @Column(name = "cource_work_ze")
    private Double courceWorkZe;

    @Column(name = "cource_work_hours")
    private Integer courceWorkHours;

    @Column(name = "id_teacher")
    private Integer idTeacher;

    @Column(name = "id_faculty")
    private Integer idFaculty;

    @Column(name = "selfeducation")
    private Integer selfeducation;

    public Integer getSelfeducation() {
        return selfeducation;
    }

    public void setSelfeducation(Integer selfeducation) {
        this.selfeducation = selfeducation;
    }

    public Integer getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(Integer idFaculty) {
        this.idFaculty = idFaculty;
    }

    public Integer getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Integer idTeacher) {
        this.idTeacher = idTeacher;
    }

    public Integer getCourceWorkHours() {
        return courceWorkHours;
    }

    public void setCourceWorkHours(Integer courceWorkHours) {
        this.courceWorkHours = courceWorkHours;
    }

    public Double getCourceWorkZe() {
        return courceWorkZe;
    }

    public void setCourceWorkZe(Double courceWorkZe) {
        this.courceWorkZe = courceWorkZe;
    }

    public Double getZe() {
        return ze;
    }

    public void setZe(Double ze) {
        this.ze = ze;
    }

    public Node getIdNode() {
        return idNode;
    }

    public void setIdNode(Node idNode) {
        this.idNode = idNode;
    }

    public String getCourseWorkType() {
        return courseWorkType;
    }

    public void setCourseWorkType(String courseWorkType) {
        this.courseWorkType = courseWorkType;
    }

    public Integer getRgr() {
        return rgr;
    }

    public void setRgr(Integer rgr) {
        this.rgr = rgr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSeminar() {
        return seminar;
    }

    public void setSeminar(Integer seminar) {
        this.seminar = seminar;
    }

    public Integer getPractice() {
        return practice;
    }

    public void setPractice(Integer practice) {
        this.practice = practice;
    }

    public Integer getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Integer laboratory) {
        this.laboratory = laboratory;
    }

    public Integer getLecture() {
        return lecture;
    }

    public void setLecture(Integer lecture) {
        this.lecture = lecture;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}