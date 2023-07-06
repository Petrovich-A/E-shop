package by.petrovich.eshop.entity.converter;

import by.petrovich.eshop.EShopApplication;
import by.petrovich.eshop.dto.CartDto;
import by.petrovich.eshop.dto.ProductDto;
import by.petrovich.eshop.entity.Cart;
import by.petrovich.eshop.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = EShopApplication.class)
class CartConverterTest {

    @Autowired
    private CartConverter cartConverter;

    @Test
    void convertToDto() {
        String nameDto = "product name test";
        String descriptionDto = "description test";
        double priceDto = 0.0;
        ProductDto productDto = ProductDto.builder()
                .name(nameDto)
                .description(descriptionDto)
                .price(priceDto)
                .build();
        List<ProductDto> productsDto = new ArrayList<>();
        productsDto.add(productDto);
        int quantity = 1;
        CartDto expected = CartDto.builder()
                .products(productsDto)
                .quantity(quantity)
                .build();

        Integer productId = 0;
        String name = "product name test";
        String description = "description test";
        double price = 0.0;
        Product product = Product.builder()
                .productId(productId)
                .name(name)
                .description(description)
                .price(price)
                .build();
        List<Product> products = new ArrayList<>();
        products.add(product);
        Integer cartId = null;
        double totalPrice = 0.0;
        Cart cart = Cart.builder()
                .cartId(cartId)
                .products(products)
                .totalPrice(totalPrice)
                .quantity(products.size())
                .build();

        CartDto actual = cartConverter.convertToDto(cart);
        assertEquals(expected, actual);
    }

    @Test
    void convertToEntity() {
        Integer productId = null;
        String name = "product name test";
        String description = "description test";
        double price = 0.0;
        Product product = Product.builder()
                .productId(productId)
                .name(name)
                .description(description)
                .price(price)
                .orders(new ArrayList<>())
                .build();
        List<Product> products = new ArrayList<>();
        products.add(product);
        Integer cartId = null;
        double totalPrice = 0.0;
        int quantity = 1;
        Cart expected = Cart.builder()
                .cartId(cartId)
                .products(products)
                .totalPrice(totalPrice)
                .quantity(quantity)
                .build();

        String nameDto = "product name test";
        String descriptionDto = "description test";
        double priceDto = 0.0;
        ProductDto productDto = ProductDto.builder()
                .name(nameDto)
                .description(descriptionDto)
                .price(priceDto)
                .build();
        List<ProductDto> productsDto = new ArrayList<>();
        productsDto.add(productDto);
        CartDto cartDto = CartDto.builder()
                .products(productsDto)
                .quantity(productsDto.size())
                .build();
        Cart actual = cartConverter.convertToEntity(cartDto);
        assertEquals(expected, actual);
    }

}