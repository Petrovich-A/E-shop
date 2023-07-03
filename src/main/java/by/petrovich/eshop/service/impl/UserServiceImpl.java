package by.petrovich.eshop.service.impl;

import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.repository.UserRepository;
import by.petrovich.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void register(RegistrationFormDto registrationFormDto) {
        if (!isExist(registrationFormDto.getEmail())) {
            User user = User.builder()
                    .name(registrationFormDto.getName())
                    .password(passwordEncoder.encode(registrationFormDto.getPassword()))
                    .email(registrationFormDto.getEmail())
                    .birthDate(registrationFormDto.getBirthDate())
                    .balance(BigDecimal.valueOf(0.0))
                    .build();
            userRepository.save(user);
        } else {
            throw new BadCredentialsException("Bad credentials");
        }
    }

    private boolean isExist(String email) {
        return userRepository.existsByEmail(email);
    }

}