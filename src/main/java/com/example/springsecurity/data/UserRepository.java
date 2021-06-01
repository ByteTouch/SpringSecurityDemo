package com.example.springsecurity.data;

import java.util.Optional;

import com.example.springsecurity.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    public Optional<User> findByUsername(String username);
}
