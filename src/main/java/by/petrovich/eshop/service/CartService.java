package by.petrovich.eshop.service;

import by.petrovich.eshop.dto.CartDto;
import by.petrovich.eshop.dto.ProductDto;

import java.util.List;

public interface CartService {

    CartDto addProduct(Integer productId, CartDto cartDto);

    CartDto removeProduct(Integer productId, CartDto cartDto);

    CartDto clear(CartDto cartDto);

    double calculateTotalPrice(List<ProductDto> productsDto);

}
