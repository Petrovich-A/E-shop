package by.petrovich.eshop.service;

import by.petrovich.eshop.dto.LogInFormDto;
import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User register(RegistrationFormDto registrationFormDto);

    User authorize(LogInFormDto logInFormDto);
}
