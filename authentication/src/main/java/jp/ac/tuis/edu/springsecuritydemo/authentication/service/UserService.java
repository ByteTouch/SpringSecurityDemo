package jp.ac.tuis.edu.springsecuritydemo.authentication.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.ac.tuis.edu.springsecuritydemo.authentication.data.OtpRepository;
import jp.ac.tuis.edu.springsecuritydemo.authentication.data.UserRepository;
import jp.ac.tuis.edu.springsecuritydemo.authentication.entity.Otp;
import jp.ac.tuis.edu.springsecuritydemo.authentication.entity.User;

@Service
@Transactional
public class UserService {
    
    private PasswordEncoder encoder;
    private UserRepository userRepo;
    private OtpRepository otpRepo;

    @Autowired
    public UserService(PasswordEncoder encoder, UserRepository userRepo, OtpRepository otpRepo) {
        this.encoder = encoder;
        this.userRepo = userRepo;
        this.otpRepo = otpRepo;
    }

    public void addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);
    }

    public void auth(User user) {
        Optional<User> optionalUser = userRepo.findByUsername(user.getUsername());
        User u = optionalUser.orElseThrow(() -> new BadCredentialsException("Bad credentials."));

        if (encoder.matches(user.getPassword(), u.getPassword())) {
            renewOtp(u);
        } else {
            throw new BadCredentialsException("Bad credentials.");
        }
    }

    public boolean check(Otp otpToValidate) {
        Optional<Otp> optionalOtp = otpRepo.findByUsername(otpToValidate.getUsername());

        if (optionalOtp.isPresent()) {
            Otp otp = optionalOtp.get();
            if (otp.getCode().equals(otpToValidate.getCode())) {
                return true;
            }
        }
        return false;
    }

    private void renewOtp(User user) {
        String code = GenerateCodeUtil.generateCode();

        Optional<Otp> optionalOtp = otpRepo.findByUsername(user.getUsername());
        Otp otp = optionalOtp.orElse(new Otp(user.getUsername()));
        otp.setCode(code);
        otpRepo.save(otp);
    }

    final static class GenerateCodeUtil {
    
        private GenerateCodeUtil() {}

        public static String generateCode() {
            String code;

            try {
                SecureRandom random = SecureRandom.getInstanceStrong();
                int c = random.nextInt(9000) + 1000;
                code = String.valueOf(c);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("Problem when generating the random code.");
            }

            return code;
        }
    }
}