package by.petrovich.eshop.repository;

import by.petrovich.eshop.EShopApplication;
import by.petrovich.eshop.entity.Category;
import by.petrovich.eshop.entity.Order;
import by.petrovich.eshop.entity.Product;
import by.petrovich.eshop.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = EShopApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void testSave() {
        User user = User.builder()
                .userId(1)
                .build();
        Product product = Product.builder()
                .productId(1)
                .name("product name1")
                .price(10.99)
                .category(Category.builder().categoryId(1).build())
                .description("description1")
                .build();
        ArrayList<Product> products = new ArrayList<>();
        products.add(product);

        Order expected = Order.builder()
                .orderId(4)
                .price(BigDecimal.valueOf(10.99))
                .user(user)
                .products(products)
                .build();
        Order order = Order.builder()
                .price(BigDecimal.valueOf(10.99))
                .user(user)
                .products(products)
                .build();
        Order actual = orderRepository.saveAndFlush(order);
        assertEquals(actual, expected);
    }

    @Test
    void testFindAllByUser() {
        User user = User.builder().userId(2).build();
        Order order = Order.builder()
                .orderId(2)
                .price(BigDecimal.valueOf(0.2))
                .createdAt(LocalDateTime.of(2023, 6, 14, 9, 37, 59, 613918))
                .user(User.builder().userId(2).build())
                .build();
        List<Order> expected = new ArrayList<>();
        expected.add(order);
        List<Order> actual = orderRepository.findAllByUser(user);
        assertEquals(actual, expected);
    }
}