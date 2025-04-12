package com.school20.school2.Controllers;

import com.school20.school2.Services.AuthenticationService;
import com.school20.school2.dto.LoginDto;
import com.school20.school2.dto.StudentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

@PostMapping("/register")
public ResponseEntity<?> register(@RequestBody StudentDto studentDto) {
    authenticationService.register(studentDto);
    return ResponseEntity.status(HttpStatus.OK).body("Registration successful! Welcome, new user with roles: " + studentDto.getRoles());
}


@PostMapping("/login")
public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
    return ResponseEntity.status(HttpStatus.OK).body("Login successful! Welcome, " + loginDto.getEmail() + ".");
}

}
