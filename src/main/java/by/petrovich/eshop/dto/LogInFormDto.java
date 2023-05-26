package by.petrovich.eshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public class LogInFormDto {
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 20, message
            = "Name must be between 2 and 20 characters")
    private String name;
    @NotBlank(message = "Password id is required")
    private String password;

}
