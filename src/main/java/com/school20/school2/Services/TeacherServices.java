//package com.school20.school2.Services;
//
//import com.school20.school2.Entitys.User;
//import com.school20.school2.Repositories.UserRepository;
//import com.school20.school2.dto.UserDto;
//import com.school20.school2.exceptions.EmailAlreadyExistsException;
//import com.school20.school2.exceptions.TeacherNotFoundException;
//import com.school20.school2.handMappers.UserMapper;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TeacherServices {
//    private final UserRepository teacherRepository;
//    private final UserMapper userMapper;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    public TeacherServices(UserRepository teacherRepository, UserMapper userMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.teacherRepository = teacherRepository;
//        this.userMapper = userMapper;
//        this.passwordEncoder = bCryptPasswordEncoder;
//    }
//
//    public void createATeacher(UserDto userDto) {
//        if (teacherRepository.existsByEmail(userDto.getEmail())) {
//            throw new EmailAlreadyExistsException("Email aread exists");
//        }
//
//        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//
//        User user = userMapper.toTeacher(userDto);
//        this.teacherRepository.save(user);
//    }
//
//
//    public UserDto getTeacherByID(Long id) {
//        User user = teacherRepository.findById(id)
//                .orElseThrow(() -> new TeacherNotFoundException("user not found"));
//        return userMapper.toTeacherDto(user);
//    }
//
//    public List<UserDto> getAllTeachers() {
//        List<User> users = teacherRepository.findAll();
//        if (users.isEmpty()) {
//            throw new TeacherNotFoundException("no users found");
//        }
//        return userMapper.toUserDtoList(users);
//    }
//}
