package by.petrovich.eshop.service.impl;

import by.petrovich.eshop.entity.Order;
import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.model.Cart;
import by.petrovich.eshop.repository.OrderRepository;
import by.petrovich.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Cart cart, Integer userId) {
        User user = new User();
        user.setUserId(userId);

        Order order = new Order();
        order.setPrice(BigDecimal.valueOf(cart.getTotalPrice()));
        order.setUser(user);
        return orderRepository.saveAndFlush(order);
    }
}
