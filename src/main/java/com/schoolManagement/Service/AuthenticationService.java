package com.schoolManagement.Service;

import com.schoolManagement.Dto.LoginDto;
import com.schoolManagement.Entity.Student;
import com.schoolManagement.Exceptions.EmailNotFoundException;
import com.schoolManagement.Repository.StudentRepository;
import com.schoolManagement.Dto.StudentDto;
import com.schoolManagement.Exceptions.EmailAlreadyExistsException;
import com.schoolManagement.Mapper.UserMapper;
import com.schoolManagement.constants.MessageConstants;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {
    private final StudentRepository studentRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(StudentRepository studentRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.studentRepository = studentRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public void register(StudentDto studentDto) {
        if (studentRepository.existsByEmail(studentDto.getEmail())) {
            throw new EmailAlreadyExistsException(MessageConstants.EMAIL_ALREADY_EXIST);
        }

        Student student = userMapper.toUser(studentDto);
        student.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        studentRepository.save(student);
    }


    public Student login(LoginDto loginDto) {
        Student student = studentRepository.findByEmail(loginDto.getEmail()).orElseThrow(() -> new EmailNotFoundException(MessageConstants.NO_EMAIL_FOUND));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        return student;
    }

}
