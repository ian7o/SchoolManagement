package com.school20.school2.Services;

import com.school20.school2.Entitys.Teacher;
import com.school20.school2.Repositories.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherServices {
    private final TeacherRepository teacherRepository;

    public TeacherServices(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher createATeacher(Teacher teacher){
       return this.teacherRepository.save(teacher);
    }
}
