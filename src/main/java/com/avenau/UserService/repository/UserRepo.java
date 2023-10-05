package com.avenau.UserService.repository;

import com.avenau.UserService.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    public Optional<User> findByUsername(String username);
}
