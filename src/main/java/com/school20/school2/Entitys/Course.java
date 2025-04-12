//package com.school20.school2.Entitys;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "course")
//public class Course {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long courseId;
//
//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "year")
//    private String year;
//
//    public Course(Long courseId, String name, String year) {
//        this.courseId = courseId;
//        this.name = name;
//        this.year = year;
//    }
//
//    public Course() {
//    }
//
//    public Long getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(Long courseId) {
//        this.courseId = courseId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getYear() {
//        return year;
//    }
//
//    public void setYear(String year) {
//        this.year = year;
//    }
//}