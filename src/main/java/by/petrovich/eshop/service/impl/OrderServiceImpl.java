package by.petrovich.eshop.service.impl;

import by.petrovich.eshop.entity.Order;
import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.entity.Cart;
import by.petrovich.eshop.repository.OrderRepository;
import by.petrovich.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order save(Cart cart, Integer userId) {
        User user = User.builder()
                .userId(userId)
                .build();
        Order order = Order.builder()
                .price(BigDecimal.valueOf(cart.getTotalPrice()))
                .user(user)
                .products(Set.copyOf(cart.getProducts()))
                .build();
        return orderRepository.saveAndFlush(order);
    }
}
