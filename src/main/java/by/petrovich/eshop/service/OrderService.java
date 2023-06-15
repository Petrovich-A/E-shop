package by.petrovich.eshop.service;

import by.petrovich.eshop.entity.Cart;
import by.petrovich.eshop.entity.Order;

import java.util.List;

public interface OrderService {
    Order save(Cart cart, Integer userId);

    List<Order> readOrders(Integer userId);

    Order read (Integer orderId);
}
