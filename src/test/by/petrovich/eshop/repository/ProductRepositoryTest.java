package by.petrovich.eshop.repository;

import by.petrovich.eshop.EShopApplication;
import by.petrovich.eshop.model.Category;
import by.petrovich.eshop.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = EShopApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void testSave() {
        Product product = Product.builder()
                .name("product name test")
                .category(Category.builder().categoryId(1).build())
                .description("description test")
                .category(Category.builder().categoryId(1).build())
                .build();
        Product savedProduct = productRepository.save(product);
        Optional<Product> existedProduct = productRepository.findById(savedProduct.getProductId());
        assertEquals(savedProduct, existedProduct.get());
    }

    @Test
    void testFindById() {
        int id = 1;
        Product actualProduct = Product.builder()
                .name("product name1")
                .price(0.01)
                .category(Category.builder().categoryId(1).build())
                .description("description1")
                .build();
        Optional<Product> expectedProduct = productRepository.findById(id);
        assertEquals(actualProduct, expectedProduct.get());

    }

    @Test
    void testFindByName() {
        String name = "product name1";
        Product actualProduct = Product.builder()
                .productId(1)
                .name("product name1")
                .price(0.01)
                .category(Category.builder().categoryId(1).build())
                .description("description1")
                .build();
        Optional<Product> expectedProduct = productRepository.findByName(name);
        assertEquals(actualProduct, expectedProduct.get());
    }

    @Test
    void testFindProductsByCategoryId() {
        Integer categoryId = 1;
        Category category = Category.builder()
                .categoryId(categoryId)
                .build();
        Product product = Product.builder()
                .productId(1)
                .name("product name1")
                .price(0.01)
                .category(category)
                .description("description1")
                .build();
        List<Product> actualProducts = new ArrayList<>();
        actualProducts.add(product);
        List<Product> expectedProducts = productRepository.findProductsByCategoryId(categoryId);
        assertEquals(actualProducts, expectedProducts);
    }

    @Test
    void testFindProductsByNameLike() {
        String searchKey = "product nam";
        Product product1 = Product.builder()
                .productId(1)
                .name("product name1")
                .price(0.01)
                .category(Category.builder().categoryId(1).build())
                .description("description1")
                .build();
        Product product2 = Product.builder()
                .productId(1)
                .name("product name1")
                .price(19.99)
                .category(Category.builder().categoryId(1).build())
                .description("Our product is a versatile and high-quality backpack designed for the modern adventurer." +
                        " With multiple pockets and compartments, it provides ample space for all your gear, whether you're " +
                        "hitting the trails or a bustling city. Made from durable materials, it's built to withstand the" +
                        " elements and last for years to come.")
                .build();
        Set<Product> actual = new HashSet<>();
        actual.add(product1);
        actual.add(product2);
        Set<Product> expected = productRepository.findProductsByNameContainingIgnoreCase(searchKey);
        assertEquals(actual, expected);
    }
}