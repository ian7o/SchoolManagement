package com.schoolManagement.controller;

import com.schoolManagement.dto.LoginDto;
import com.schoolManagement.entity.Student;
import com.schoolManagement.dto.LoginResponse;
import com.schoolManagement.service.AuthenticationService;
import com.schoolManagement.dto.StudentDto;
import com.schoolManagement.service.JWTService;
import com.schoolManagement.utils.MessageConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    private final JWTService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationController(AuthenticationService authenticationService, JWTService jwtService, AuthenticationManager authenticationManager) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody StudentDto studentDto) {
        authenticationService.register(studentDto);
        return ResponseEntity.status(HttpStatus.OK).body(MessageConstants.USER_REGISTERED_SUCCESSFULLY + studentDto.getRole());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto) {
        Student authenticatedUser = authenticationService.login(loginDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getJwtExpiration());
        return ResponseEntity.ok(loginResponse);
    }

}