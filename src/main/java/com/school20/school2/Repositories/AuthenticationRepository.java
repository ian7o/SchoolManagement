package com.school20.school2.Repositories;

import com.school20.school2.Entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepository extends JpaRepository<User, Long> {

    boolean findByEmail(String email);
}
