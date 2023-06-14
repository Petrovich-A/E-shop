package by.petrovich.eshop.repository;

import by.petrovich.eshop.entity.Order;
import by.petrovich.eshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUser(User user);

}
