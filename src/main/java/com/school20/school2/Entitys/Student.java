//package com.school20.school2.Entitys;
//
//import com.school20.school2.security.RolesEnum;
//import jakarta.persistence.*;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "student")
//public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long studentId;
//
//    @Column(name = "firstName", nullable = false)
//    private String firstName;
//
//    @Column(name = "lastName", nullable = false)
//    private String lastName;
//
//    @Column(name = "email", nullable = false)
//    private String email;
//
//    @Column(name = "gender", nullable = false)
//    private String gender;
//
//    @Column(name = "birthDay", nullable = false)
//    private String birthDay;
//
//    @Enumerated(EnumType.STRING)
//    private Set<RolesEnum> roles= new HashSet<>();
//
////    @ManyToOne
////    @JoinColumn(name = "teacherId")
////    private User teachers;
//
//    // É assim o relacinamento entre teachers e studantes
////        @ManyToMany
////    @JoinTable(name = "student_Teacher",
////    joinColumns = @JoinColumn(name = "studentId"),
////    inverseJoinColumns = @JoinColumn(name = "teacherId"))
////    @Column(name = "teacherId")
////    private Set<User> teachers;
//
//
//    public Student(Long studentId, String firstName, String lastName, String email, String gender, String birthDay, Set<RolesEnum> roles) {
//        this.studentId = studentId;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.gender = gender;
//        this.birthDay = birthDay;
//        this.roles = roles;
//    }
//
//    public Student() {
//    }
//
//    public Long getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(Long studentId) {
//        this.studentId = studentId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public String getBirthDay() {
//        return birthDay;
//    }
//
//    public void setBirthDay(String birthDay) {
//        this.birthDay = birthDay;
//    }
//
//    public Set<RolesEnum> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<RolesEnum> roles) {
//        this.roles = roles;
//    }
//}