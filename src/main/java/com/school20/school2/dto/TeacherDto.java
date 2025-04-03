package com.school20.school2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class TeacherDto {

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 50)
    private String firstName;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 50)
    private String lastName;

    @NotNull
    @NotBlank
    @NotEmpty
    private String email;

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 50)
    private String gender;

    @NotNull
    @Size(min = 3, max = 50)
    private String birthDay;


    public TeacherDto(String firstName, String lastName, String email, String gender, String birthDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthDay = birthDay;
    }

    public TeacherDto() {
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


}

