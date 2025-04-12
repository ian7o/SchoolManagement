package com.school20.school2.Services;

import com.school20.school2.Entitys.Student;
import com.school20.school2.Repositories.UserRepository;
import com.school20.school2.dto.LoginDto;
import com.school20.school2.dto.StudentDto;
import com.school20.school2.exceptions.EmailAlreadyExistsException;
import com.school20.school2.handMappers.UserMapper;
import jakarta.validation.Valid;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
public class AuthenticationService  {
    private  final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public void register(StudentDto studentDto) {
         if (userRepository.existsByEmail(studentDto.getEmail())){
                  throw new EmailAlreadyExistsException("Email already exists");
         }

        Student student = userMapper.toUser(studentDto);
        student.setPassword(passwordEncoder.encode(studentDto.getPassword()));
        userRepository.save(student);
    }

    public Authentication authenticate(@Valid LoginDto loginDto) throws AuthenticationException {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

        return authenticationManager.authenticate(authenticationToken);
    }
}
