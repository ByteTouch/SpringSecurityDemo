package jp.ac.tuis.edu.springsecuritydemo.authentication.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.tuis.edu.springsecuritydemo.authentication.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    public Optional<User> findByUsername(String username);
    
}
