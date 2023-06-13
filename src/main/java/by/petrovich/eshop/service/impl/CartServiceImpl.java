package by.petrovich.eshop.service.impl;

import by.petrovich.eshop.entity.Cart;
import by.petrovich.eshop.entity.Product;
import by.petrovich.eshop.repository.ProductRepository;
import by.petrovich.eshop.service.CartService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private ProductRepository productRepository;


    @Autowired
    public CartServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Cart addProduct(Integer productId, Cart cart) {
        Optional<Product> product = productRepository.findProductByProductId(productId);
        List<Product> products;
        if (cart.getProducts() != null) {
            products = cart.getProducts();
        } else {
            products = new ArrayList<>();
        }
        products.add(product.get());
        cart = Cart.builder()
                .products(products)
                .quantity(products.size())
                .totalPrice(calculateTotalPrice(products))
                .build();
        return cart;
    }

    @Override
    public Cart removeProduct(Integer productId, Cart cart) {
        List<Product> products = cart.getProducts();
        products.removeIf(product -> product.getProductId().equals(productId));
        cart = Cart.builder()
                .products(products)
                .totalPrice(calculateTotalPrice(products))
                .quantity(products.size()).build();
        return cart;
    }

    @Override
    public Cart clear(Cart cart) {
        List<Product> products = cart.getProducts();
        products.clear();
        cart = Cart.builder()
                .products(products)
                .totalPrice(0.0)
                .quantity(0)
                .build();
        return cart;
    }

    private double calculateTotalPrice(List<Product> products) {
        double sum = 0.0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }

}
