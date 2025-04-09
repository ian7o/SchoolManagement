package com.school20.school2.dto;

import com.school20.school2.enums.Roles;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Size;


public class UserDto {

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
    @Size(min = 3, max = 50)
    private String gender;

//    @NotNull
    @Size(min = 3, max = 50)
    private String birthDay;

    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String email, String gender, String birthDay, String password, Roles roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.birthDay = birthDay;
        this.password = password;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }
}