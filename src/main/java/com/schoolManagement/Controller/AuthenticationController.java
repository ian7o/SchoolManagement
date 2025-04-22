package com.schoolManagement.Controller;

import com.schoolManagement.Dto.LoginDto;
import com.schoolManagement.Entity.Student;
import com.schoolManagement.Dto.LoginResponse;
import com.schoolManagement.Service.AuthenticationService;
import com.schoolManagement.Dto.StudentDto;
import com.schoolManagement.Service.JWTService;
import com.schoolManagement.constants.MessageConstants;
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