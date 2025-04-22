package com.schoolManagement.service.mapper;

import com.schoolManagement.entity.Student;
import com.schoolManagement.dto.StudentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    StudentDto toUserDto(Student student);

    Student toUser(StudentDto studentDto);

    List<StudentDto> toUserDtoList(List<Student> students);

}