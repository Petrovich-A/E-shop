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
import java.util.HashSet;
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
        Set<Product> products = new HashSet<>();
        products.add(product);

        Order actual = Order.builder()
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
        Order expected = orderRepository.saveAndFlush(order);
        assertEquals(actual, expected);
    }

}