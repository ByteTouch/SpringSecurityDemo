package jp.ac.tuis.edu.springsecuritydemo.authentication.security;

/*

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.ac.tuis.edu.springsecuritydemo.authentication.data.UserRepository;
import jp.ac.tuis.edu.springsecuritydemo.authentication.entity.User;

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
    
    public void addUser(User user) {
        userRepo.addUser(user);
    }
}

*/
