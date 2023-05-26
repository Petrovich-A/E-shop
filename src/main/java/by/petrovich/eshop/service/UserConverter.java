package by.petrovich.eshop.service;

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

    public RegistrationFormDto convertToDto(User user) {
        return modelMapper.map(user, RegistrationFormDto.class);
    }

    public User convertToEntity(RegistrationFormDto registrationFormDto) {
        return modelMapper.map(registrationFormDto, User.class);
    }
}
