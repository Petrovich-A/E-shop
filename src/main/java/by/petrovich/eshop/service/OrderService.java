package by.petrovich.eshop.service;

import by.petrovich.eshop.entity.Order;
import by.petrovich.eshop.model.Cart;

public interface OrderService {
    Order save(Cart cart, Integer userId);
}