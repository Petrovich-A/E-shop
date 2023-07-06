package by.petrovich.eshop.service.impl;

import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.entity.Role;
import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.exceptions.UserNotFoundException;
import by.petrovich.eshop.repository.RoleRepository;
import by.petrovich.eshop.repository.UserRepository;
import by.petrovich.eshop.entity.model.CustomUserDetail;
import by.petrovich.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    private UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void register(RegistrationFormDto registrationFormDto) {
        Role role = roleRepository.findByName("ROLE_USER");
        if (!isExist(registrationFormDto.getEmail()) && role != null) {
            User user = User.builder()
                    .name(registrationFormDto.getName())
                    .password(passwordEncoder.encode(registrationFormDto.getPassword()))
                    .email(registrationFormDto.getEmail())
                    .birthDate(registrationFormDto.getBirthDate())
                    .balance(BigDecimal.valueOf(0.0))
                    .role(role)
                    .build();
            userRepository.save(user);
        } else {
            throw new BadCredentialsException("Bad credentials");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UserNotFoundException {
        User user = userRepository.findByName(name).orElseThrow(()
                -> new UserNotFoundException("User not found"));
        return new CustomUserDetail(user);
    }

    private boolean isExist(String email) {
        return userRepository.existsByEmail(email);
    }

}
