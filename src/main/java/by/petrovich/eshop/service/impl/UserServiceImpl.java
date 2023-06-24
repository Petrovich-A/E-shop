package by.petrovich.eshop.service.impl;

import by.petrovich.eshop.dto.LogInFormDto;
import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.repository.UserRepository;
import by.petrovich.eshop.entity.converter.UserConverter;
import by.petrovich.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    private UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User register(RegistrationFormDto registrationFormDto) {
        User user = new User();
        if (!isExist(registrationFormDto.getEmail())) {
            user = userConverter.convertRegisterToEntity(registrationFormDto);
            return userRepository.save(user);
        } else {
            // TODO: 25.05.2023
        }
        return user;
    }

    public User authorize(LogInFormDto logInFormDto) {
        Optional<User> user = userRepository.findByNameAndPassword(logInFormDto.getName(), logInFormDto.getPassword());
        return user.orElse(null);
    }

    private boolean isExist(String email) {
        return userRepository.existsByEmail(email);
    }

}