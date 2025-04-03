package com.school20.school2.Entitys;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "birthDay", nullable = false)
    private String birthDay;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private Teacher teachers;

    // É assim o relacinamento entre teachers e studantes
//        @ManyToMany
//    @JoinTable(name = "student_Teacher",
//    joinColumns = @JoinColumn(name = "studentId"),
//    inverseJoinColumns = @JoinColumn(name = "teacherId"))
//    @Column(name = "teacherId")
//    private Set<Teacher> teachers;

    public Student(Long studentId, String firstName, String lastName, String email, String gender, String birthDay, Teacher teachers) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthDay = birthDay;
        this.teachers = teachers;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Teacher getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher teachers) {
        this.teachers = teachers;
    }


}