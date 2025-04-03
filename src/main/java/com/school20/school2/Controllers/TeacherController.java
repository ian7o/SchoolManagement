package com.school20.school2.Controllers;

import com.school20.school2.Services.TeacherServices;
import com.school20.school2.dto.TeacherDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableWebSecurity
@RequestMapping("api/v1/teacher")
public class TeacherController {

    private final TeacherServices teacherServices;

    public TeacherController(TeacherServices teacherServices) {
        this.teacherServices = teacherServices;
    }

    @PostMapping(path = "/create")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<?> createTeacher(@RequestBody @Valid TeacherDto teacherDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.getFieldError().getDefaultMessage() + " In: " + bindingResult.getFieldError().getRejectedValue());
        }
        this.teacherServices.createATeacher(teacherDto);
        return ResponseEntity.ok().body("user Created");
    }

    @RequestMapping("{id}")
    @PreAuthorize("hasRole('test')")
    public ResponseEntity<TeacherDto> findTeacherById(@PathVariable("id") Long id) {
        TeacherDto teacherDto = teacherServices.getTeacherByID(id);
        return ResponseEntity.ok().body(teacherDto);
    }

    @RequestMapping
    @PreAuthorize("hasRole('test')")
    public ResponseEntity<List<TeacherDto>> AllTeachers() {
        List<TeacherDto> teacherDtoList = teacherServices.getAllTeachers();
        return ResponseEntity.ok().body(teacherDtoList);
    }


}
