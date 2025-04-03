package com.school20.school2.Entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "feedbackTable")
public class FeedbackTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

    @Column(name = "grades")
    private Integer grades;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student studentId;

    @Column(name = "feedback")
    private String feedback;

    public FeedbackTable(Long id, Course course, Teacher teacher, Integer grades, Student studentId, String feedback) {
        this.id = id;
        this.course = course;
        this.teacher = teacher;
        this.grades = grades;
        this.studentId = studentId;
        this.feedback = feedback;
    }

    public FeedbackTable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Integer getGrades() {
        return grades;
    }

    public void setGrades(Integer grades) {
        this.grades = grades;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}