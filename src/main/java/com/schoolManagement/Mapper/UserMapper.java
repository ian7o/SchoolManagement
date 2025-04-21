package com.schoolManagement.Mapper;

import com.schoolManagement.Entity.Student;
import com.schoolManagement.Dto.StudentDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    StudentDto toUserDto(Student student);

    Student toUser(StudentDto studentDto);

    List<StudentDto> toUserDtoList(List<Student> students);

}