package by.petrovich.eshop.service;

import by.petrovich.eshop.entity.Cart;

public interface CartService {

    Cart addProduct(Integer productId, Cart cart);

    Cart removeProduct(Integer productId, Cart cart);

    Cart clear(Cart cart);

}
