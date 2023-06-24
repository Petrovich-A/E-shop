package by.petrovich.eshop.service.impl;

import by.petrovich.eshop.EShopApplication;
import by.petrovich.eshop.dto.ProductDto;
import by.petrovich.eshop.service.CartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = EShopApplication.class)
class CartServiceImplTest {
    private final CartService cartService;

    @Autowired
    CartServiceImplTest(CartService cartService) {
        this.cartService = cartService;
    }

    @Test
    void calculateTotalPrice() {
        double price1 = 10.0;
        double price2 = 5.55;
        ProductDto productDto1 = ProductDto.builder().price(price1).build();
        ProductDto productDto2 = ProductDto.builder().price(price2).build();
        ArrayList<ProductDto> productsDto = new ArrayList<>();
        productsDto.add(productDto1);
        productsDto.add(productDto2);
        double actual = cartService.calculateTotalPrice(productsDto);
        double expected = 15.55;
        assertEquals(expected, actual);
    }
}