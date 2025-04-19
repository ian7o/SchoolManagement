package com.school20.school2.Controllers;

import com.school20.school2.Entitys.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    //only for test
    @GetMapping("/thisStudent")
    public ResponseEntity<Student> authenticateUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Student current = (Student) authentication.getPrincipal();

        return ResponseEntity.status(HttpStatus.OK).body(current);
    }
}
