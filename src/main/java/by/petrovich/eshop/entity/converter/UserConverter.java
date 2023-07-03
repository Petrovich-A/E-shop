package by.petrovich.eshop.entity.converter;

import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    private final ModelMapper modelMapper;

    @Autowired
    public UserConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public RegistrationFormDto convertToRegisterFormDto(User user) {
        return modelMapper.map(user, RegistrationFormDto.class);
    }

    public User convertRegisterToEntity(RegistrationFormDto registrationFormDto) {
        return modelMapper.map(registrationFormDto, User.class);
    }

}
