package com.school20.school2.handMappers;

import com.school20.school2.Entitys.Teacher;
import com.school20.school2.dto.TeacherDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherMapperTest {

    private TeacherMapper teacherMapper = new TeacherMapper();

    @Test
    public void teacherDtoOk() {
        Teacher teacher = Teacher.builder()
                .teacherId(1L)
                .firstName("mario")
                .lastName("careca")
                .email("xx@gmail.com")
                .gender("femea")
                .birthDay("20/12/2020")
                .build();

        TeacherDto teacherDto = teacherMapper.toTeacherDto(teacher);
        assertEquals(teacher.getFirstName(), teacherDto.getFirstName());
        assertEquals(teacher.getLastName(), teacherDto.getLastName());
        assertEquals(teacher.getEmail(), teacherDto.getEmail());
        assertEquals(teacher.getGender(), teacherDto.getGender());
        assertEquals(teacher.getBirthDay(), teacherDto.getBirthDay());
    }

    @Test
    public void teacherDtoOkEmpty() {
        Teacher teacher = new Teacher();
        TeacherDto teacherDto = teacherMapper.toTeacherDto(teacher);
        assertNull(teacherDto.getFirstName());
        assertNull(teacherDto.getLastName());
        assertNull(teacherDto.getEmail());
        assertNull(teacherDto.getGender());
        assertNull(teacherDto.getBirthDay());
    }

}