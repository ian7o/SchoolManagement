//package com.school20.school2.Controllers;
//
//import com.school20.school2.dto.UserDto;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/v1/teacher")
//public class TeacherController {
//
//
//
//
//    @GetMapping("{id}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public ResponseEntity<UserDto> findTeacherById(@PathVariable("id") Long id) {
//        UserDto userDto = teacherServices.getTeacherByID(id);
//        return ResponseEntity.ok().body(userDto);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<UserDto>> AllTeachers() {
//        List<UserDto> userDtoList = teacherServices.getAllTeachers();
//        return ResponseEntity.ok().body(userDtoList);
//    }
//
//
//}
