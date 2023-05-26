package by.petrovich.eshop.service;

import by.petrovich.eshop.dto.LogInFormDto;
import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("userConverter")
public class UserConverter {
    private final ModelMapper modelMapper;

    public UserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RegistrationFormDto convertToRegisterFormDto(User user) {
        return modelMapper.map(user, RegistrationFormDto.class);
    }

    public User convertRegisterToEntity(RegistrationFormDto registrationFormDto) {
        return modelMapper.map(registrationFormDto, User.class);
    }

    public LogInFormDto convertToLogInFormDto(User user){
        return modelMapper.map(user, LogInFormDto.class);
    }

    public User convertLogInToEntity(LogInFormDto logInFormDto){
        return modelMapper.map(logInFormDto, User.class);
    }
}
