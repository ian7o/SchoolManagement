package com.school20.school2.Controllers;

import com.school20.school2.Entitys.Teacher;
import com.school20.school2.Services.TeacherServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {

    private final TeacherServices teacherServices;

    @PostMapping(path = "/create")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
        this.teacherServices.createATeacher(teacher);
        return ResponseEntity.ok().build();
    }

}
