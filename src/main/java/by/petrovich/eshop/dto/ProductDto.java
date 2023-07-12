package by.petrovich.eshop.dto;

import by.petrovich.eshop.entity.Image;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    @Positive
    private Integer productId;
    @Size(min = 2, max = 20)
    private String name;
    @Size(min = 5, max = 400)
    private String description;
    @DecimalMin(value = "0.0")
    private double price;
    private Image image;
}
