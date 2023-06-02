package by.petrovich.eshop.service;

import by.petrovich.eshop.model.Cart;
import by.petrovich.eshop.entity.Product;

import java.util.Optional;

public interface CartService {
    Cart addProductToCart(Integer productId, Cart cart);
}
