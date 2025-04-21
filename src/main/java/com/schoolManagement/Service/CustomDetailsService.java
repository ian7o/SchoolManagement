package com.schoolManagement.Service;

import com.schoolManagement.Repository.StudentRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomDetailsService implements UserDetailsService {
    private final StudentRepository studentRepository;
    //aqui usar os outros repos
    public CustomDetailsService(StudentRepository StudentRepository) {
        this.studentRepository = StudentRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> foundedUser = studentRepository.findByEmail(username).map(student -> (UserDetails) student);
//                    .or( () -> studentRepository.findByEmail(username).map( student -> (UserDetails) student));
        return foundedUser.orElseThrow(() -> new UsernameNotFoundException("no found yo in chain"));
    }
}
