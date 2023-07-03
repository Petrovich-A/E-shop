package by.petrovich.eshop.security;

import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.repository.UserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws BadCredentialsException {
        User user = userRepository.findByName(name).orElseThrow(()
                -> new BadCredentialsException("Bad credentials"));
        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), Collections.emptyList());
    }

}