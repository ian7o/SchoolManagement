package com.schoolManagement.Service;

import com.schoolManagement.Dto.LoginDto;
import com.schoolManagement.Entity.Student;
import com.schoolManagement.Exceptions.StudentEmailNotFoundException;
import com.schoolManagement.Repository.StudentRepository;
import com.schoolManagement.Dto.StudentDto;
import com.schoolManagement.Exceptions.EmailAlreadyExistsException;
import com.schoolManagement.Mapper.UserMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService  {
    private  final StudentRepository studentRepository;
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
         if (studentRepository.existsByEmail(studentDto.getEmail())){
                  throw new EmailAlreadyExistsException("Email already exists");
         }

        Student student = userMapper.toUser(studentDto);
        student.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        studentRepository.save(student);
    }



    public Student login(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        return studentRepository.findByEmail(loginDto.getEmail()).orElseThrow(() ->new StudentEmailNotFoundException("No Student found with the provided email."));
    }

}
