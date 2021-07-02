package jp.ac.tuis.edu.springsecuritydemo.authentication.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.tuis.edu.springsecuritydemo.authentication.entity.Otp;

@Repository
public interface OtpRepository extends JpaRepository<Otp, String> {
    
    Optional<Otp> findByUsername(String username);
}
