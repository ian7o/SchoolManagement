package com.school20.school2.handMappers;

import com.school20.school2.Entitys.Student;
import com.school20.school2.dto.StudentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    StudentDto toUserDto(Student student);

    Student toUser(StudentDto studentDto);

    List<StudentDto> toUserDtoList(List<Student> students);

}