package com.school20.school2.Services;

import com.school20.school2.Entitys.User;
import com.school20.school2.Repositories.AuthenticationRepository;
import com.school20.school2.dto.UserDto;
import com.school20.school2.exceptions.EmailAlreadyExistsException;
import com.school20.school2.handMappers.UserMapper;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService  {
    private final AuthenticationRepository authenticationRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;



    public AuthenticationService(AuthenticationRepository authenticationRepository, UserMapper userMapper, BCryptPasswordEncoder passwordEncoder) {
        this.authenticationRepository = authenticationRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(@Valid UserDto userDto) {
        if (authenticationRepository.findByEmail(userDto.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists");
        }

        User user = userMapper.toUser(userDto);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        authenticationRepository.save(user);
    }

}
