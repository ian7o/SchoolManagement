package com.school20.school2.handMappers;

import com.school20.school2.Entitys.Teacher;
import com.school20.school2.dto.TeacherDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper   {

    TeacherDto toTeacherDto(Teacher teacher);

    Teacher toTeacher(TeacherDto teacherDt);

    List<TeacherDto> toTeacherDtoList(List<Teacher> teachers);
    
}