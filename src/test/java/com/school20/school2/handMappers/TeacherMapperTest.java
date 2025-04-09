//package com.school20.school2.handMappers;
//
//import com.school20.school2.Entitys.User;
//import com.school20.school2.dto.UserDto;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TeacherMapperTest {
//
//    private UserMapper teacherMapper = new UserMapper();
//
//    @Test
//    public void teacherDtoOk() {
//        User teacher = User.builder()
//                .teacherId(1L)
//                .firstName("mario")
//                .lastName("careca")
//                .email("xx@gmail.com")
//                .gender("femea")
//                .birthDay("20/12/2020")
//                .build();
//
//        UserDto teacherDto = teacherMapper.toTeacherDto(teacher);
//        assertEquals(teacher.getFirstName(), teacherDto.getFirstName());
//        assertEquals(teacher.getLastName(), teacherDto.getLastName());
//        assertEquals(teacher.getEmail(), teacherDto.getEmail());
//        assertEquals(teacher.getGender(), teacherDto.getGender());
//        assertEquals(teacher.getBirthDay(), teacherDto.getBirthDay());
//    }
//
//    @Test
//    public void teacherDtoOkEmpty() {
//        User teacher = new User();
//        UserDto teacherDto = teacherMapper.toTeacherDto(teacher);
//        assertNull(teacherDto.getFirstName());
//        assertNull(teacherDto.getLastName());
//        assertNull(teacherDto.getEmail());
//        assertNull(teacherDto.getGender());
//        assertNull(teacherDto.getBirthDay());
//    }
//
//}