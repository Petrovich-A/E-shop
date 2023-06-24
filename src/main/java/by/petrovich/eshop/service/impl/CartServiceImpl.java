package by.petrovich.eshop.service.impl;

import by.petrovich.eshop.dto.CartDto;
import by.petrovich.eshop.dto.ProductDto;
import by.petrovich.eshop.entity.Product;
import by.petrovich.eshop.entity.converter.CartConverter;
import by.petrovich.eshop.entity.converter.ProductConverter;
import by.petrovich.eshop.repository.ProductRepository;
import by.petrovich.eshop.service.CartService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    @Autowired
    public CartServiceImpl(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    @Override
    public CartDto addProduct(Integer productId, CartDto cartDto) {
        List<ProductDto> products = new ArrayList<>();
        if (productId != null && cartDto != null) {
            Optional<Product> product = productRepository.findProductByProductId(productId);
            ProductDto productDto = productConverter.convertToDto(product.orElse(null));
            products = cartDto.getProducts();
            products.add(productDto);
            cartDto.setProducts(products);
        }
        return CartDto.builder()
                .products(products)
                .totalPrice(calculateTotalPrice(products))
                .quantity(products.size())
                .build();
    }

    @Override
    public CartDto removeProduct(Integer productId, CartDto cartDto) {
        List<ProductDto> products = cartDto.getProducts();
        products.removeIf(product -> product.getProductId().equals(productId));
        return CartDto.builder()
                .products(products)
                .totalPrice(calculateTotalPrice(products))
                .quantity(products.size())
                .build();
    }

    @Override
    public CartDto clear(CartDto cartDto) {
        List<ProductDto> productsDto = cartDto.getProducts();
        productsDto.clear();
        return CartDto.builder()
                .products(new ArrayList<>())
                .totalPrice(0.0)
                .quantity(0)
                .build();
    }

    @Override
    public double calculateTotalPrice(List<ProductDto> productsDto) {
        return productsDto.stream().mapToDouble(ProductDto::getPrice).sum();
    }

}
