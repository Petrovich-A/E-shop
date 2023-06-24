package by.petrovich.eshop.service.impl;

import by.petrovich.eshop.dto.CartDto;
import by.petrovich.eshop.entity.Cart;
import by.petrovich.eshop.entity.Order;
import by.petrovich.eshop.entity.User;
import by.petrovich.eshop.entity.converter.CartConverter;
import by.petrovich.eshop.repository.OrderRepository;
import by.petrovich.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CartConverter cartConverter;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, CartConverter cartConverter) {
        this.orderRepository = orderRepository;
        this.cartConverter = cartConverter;
    }

    @Override
    public Order save(CartDto cartDto, Integer userId) {
        Cart cart = cartConverter.convertToEntity(cartDto);
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

    @Override
    public List<Order> readOrders(Integer userId) {
        User user = User.builder()
                .userId(userId)
                .build();
        return orderRepository.findAllByUser(user);
    }

    @Override
    public Order read(Integer orderId) {
        return orderRepository.findByOrderId(orderId);
    }
}
