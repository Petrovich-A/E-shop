package by.petrovich.eshop.repository;

import by.petrovich.eshop.EShopApplication;
import by.petrovich.eshop.model.Category;
import by.petrovich.eshop.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Integer categoryId = 3;
        Category category = Category.builder()
                .categoryId(categoryId)
                .build();
        Product product = Product.builder()
                .productId(3)
                .name("product name3")
                .price(0)
                .category(category)
                .description("description3")
                .build();
        List<Product> actualProducts = new ArrayList<>();
        actualProducts.add(product);
        List<Product> expectedProducts = productRepository.findProductsByCategoryId(categoryId);
        assertEquals(actualProducts, expectedProducts);
    }
}