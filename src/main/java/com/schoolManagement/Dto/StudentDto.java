package com.schoolManagement.Dto;

import com.schoolManagement.Enum.Gender;
import com.schoolManagement.Enum.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;


public class StudentDto {

    //    @NotNull
//    @NotBlank
//    @NotEmpty
    @Size(min = 3, max = 50)
    private String firstName;

    //    @NotNull
//    @NotBlank
//    @NotEmpty
    @Size(min = 3, max = 50)
    private String lastName;

    //    @NotNull
//    @NotBlank
//    @NotEmpty
    private String email;

    //    @NotNull
//    @NotBlank
//    @NotEmpty

//    @Size(min = 3, max = 50)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    //    @NotNull
    private String birthDay;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public StudentDto() {
    }

    public StudentDto(String firstName, String lastName, String email, Gender gender, String birthDay, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthDay = birthDay;
        this.password = password;
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}