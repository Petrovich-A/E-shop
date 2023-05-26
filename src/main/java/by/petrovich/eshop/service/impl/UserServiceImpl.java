package by.petrovich.eshop.service.impl;

import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.model.User;
import by.petrovich.eshop.repository.UserRepository;
import by.petrovich.eshop.service.UserConverter;
import by.petrovich.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User save(RegistrationFormDto registrationFormDto) {
        User user = new User();
        if (!isExist(registrationFormDto.getEmail())) {
            user = userConverter.convertToEntity(registrationFormDto);
            return userRepository.save(user);
        } else {
                // TODO: 25.05.2023
        }
        return user;
    }

    private boolean isExist(String email) {
        return userRepository.existsByEmail(email);
    }

}
