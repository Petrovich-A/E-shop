package by.petrovich.eshop.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Builder
public class RegistrationFormDto {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    private String name;
    @NotBlank(message = "Password is required")
    @Size(min = 2, max = 20, message = "Password id is required")
    // TODO: add validator 28 мая 2023 г.
    private String password;
    @NotNull
    @Email(message = "Email is not valid")
    private String email;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

}
