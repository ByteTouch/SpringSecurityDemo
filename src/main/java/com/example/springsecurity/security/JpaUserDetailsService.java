package com.example.springsecurity.security;

import com.example.springsecurity.data.UserRepository;
import com.example.springsecurity.domain.User;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    public JpaUserDetailsService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Problem during authentication!"));
        
        return new CustomUserDetails(user);
    }
    
}
