package com.school20.school2.Services;

import com.school20.school2.Entitys.Teacher;
import com.school20.school2.Repositories.TeacherRepository;
import com.school20.school2.dto.TeacherDto;
import com.school20.school2.exceptions.TeacherNotFoundException;
import com.school20.school2.handMappers.TeacherMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServices {
    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherServices(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    public void createATeacher(TeacherDto teacherDto) {
        Teacher teacher = teacherMapper.toTeacher(teacherDto);
        this.teacherRepository.save(teacher);
    }

    public TeacherDto getTeacherByID(Long id){
       Teacher teacher =  teacherRepository.findById(id)
               .orElseThrow(() -> new TeacherNotFoundException("teacher not found"));
       return teacherMapper.toTeacherDto(teacher);
    }

    public List<TeacherDto> getAllTeachers(){
        List<Teacher> teachers = teacherRepository.findAll();
        if (teachers.isEmpty()){
            throw new TeacherNotFoundException("no teachers found");
        }
        return teacherMapper.toTeacherDtoList(teachers);
    }
}
