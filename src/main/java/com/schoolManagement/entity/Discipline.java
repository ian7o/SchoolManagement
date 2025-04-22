package com.schoolManagement.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "discipline")
public class Discipline {
    @Column(name ="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long disciplineID;

    @Column(name = "discipline_Name")
    private String disciplineName;

    @ManyToOne
    @JoinColumn(name = "course_Id")
    private Course course;

    public Discipline() {
    }

    public Discipline(Long disciplineID, String disciplineName, Course course) {
        this.disciplineID = disciplineID;
        this.disciplineName = disciplineName;
        this.course = course;
    }

    public Long getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(Long disciplineID) {
        this.disciplineID = disciplineID;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}