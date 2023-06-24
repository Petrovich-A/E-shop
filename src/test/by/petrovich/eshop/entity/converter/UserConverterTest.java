package by.petrovich.eshop.entity.converter;

import by.petrovich.eshop.EShopApplication;
import by.petrovich.eshop.dto.LogInFormDto;
import by.petrovich.eshop.dto.RegistrationFormDto;
import by.petrovich.eshop.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = EShopApplication.class)
class UserConverterTest {
    @Autowired
    private UserConverter userConverter;

    @Test
    void convertToDto() {
        User user = User.builder()
                .name("Wade")
                .password("Williams")
                .email("williams@mail.com")
                .birthDate(LocalDate.of(1990, 1, 1))
                .build();
        RegistrationFormDto actual = RegistrationFormDto.builder()
                .name("Wade")
                .password("Williams")
                .email("williams@mail.com")
                .birthDate(LocalDate.of(1990, 1, 1))
                .build();
        RegistrationFormDto expected = userConverter.convertToRegisterFormDto(user);
        assertEquals(actual, expected);
    }

    @Test
    void convertToEntity() {
        RegistrationFormDto registrationFormDto = RegistrationFormDto.builder()
                .name("Wade")
                .password("Williams")
                .email("williams@mail.com")
                .birthDate(LocalDate.of(1990, 1, 1))
                .build();
        User actual = User.builder()
                .name("Wade")
                .password("Williams")
                .email("williams@mail.com")
                .birthDate(LocalDate.of(1990, 1, 1))
                // TODO: 25 мая 2023 г.
                .orders(new HashSet<>())
                .build();
        User expected = userConverter.convertRegisterToEntity(registrationFormDto);
        assertEquals(actual, expected);
    }

    @Test
    void convertToLogInFormDto() {
        User user = User.builder()
                .name("Wade")
                .password("Williams")
                .build();
        LogInFormDto actual = LogInFormDto.builder()
                .name("Wade")
                .password("Williams")
                .build();
        LogInFormDto expected = userConverter.convertToLogInFormDto(user);
        assertEquals(actual, expected);
    }

    @Test
    void convertToLogInFormEntity() {
        LogInFormDto logInFormDto = LogInFormDto.builder()
                .name("Wade")
                .password("Williams")
                .build();
        User actual = User.builder()
                .name("Wade")
                .password("Williams")
                // TODO: 26.05.2023
                .orders(new HashSet<>())
                .build();
        User expected = userConverter.convertLogInToEntity(logInFormDto);
        assertEquals(actual, expected);
    }
}