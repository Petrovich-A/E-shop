package by.petrovich.eshop.service.impl;

import by.petrovich.eshop.model.Cart;
import by.petrovich.eshop.entity.Product;
import by.petrovich.eshop.repository.ProductRepository;
import by.petrovich.eshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    private ProductRepository productRepository;

    @Autowired
    public CartServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Cart addProductToCart(Integer productId, Cart cart) {
        Optional<Product> product = productRepository.findProductByProductId(productId);
        product.ifPresent(cart::addProduct);
        return cart;
    }

}
