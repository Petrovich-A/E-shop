package by.petrovich.eshop.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDto {
    @NotNull
    private List<ProductDto> products = new ArrayList<>();
    @DecimalMin(value = "0.0")
    private double totalPrice;
    private int quantity;

}