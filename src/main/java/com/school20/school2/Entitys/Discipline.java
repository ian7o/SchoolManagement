//package com.school20.school2.Entitys;
//
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "discipline")
//public class Discipline {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "disciplineName")
//    private String disciplineName;
//
//    @ManyToOne
//    @JoinColumn(name = "courseId")
//    private Course course;
//
//    public Discipline(Long id, String disciplineName, Course course) {
//        this.id = id;
//        this.disciplineName = disciplineName;
//        this.course = course;
//    }
//
//    public Discipline() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getDisciplineName() {
//        return disciplineName;
//    }
//
//    public void setDisciplineName(String disciplineName) {
//        this.disciplineName = disciplineName;
//    }
//
//    public Course getCourse() {
//        return course;
//    }
//
//    public void setCourse(Course course) {
//        this.course = course;
//    }
//}