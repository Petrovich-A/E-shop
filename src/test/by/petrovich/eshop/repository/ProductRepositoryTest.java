package by.petrovich.eshop.repository;

import by.petrovich.eshop.EShopApplication;
import by.petrovich.eshop.entity.Category;
import by.petrovich.eshop.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
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
        String searchKey = "test";
        String searchKey1 = "test";
        Product product1 = Product.builder()
                .productId(8)
                .name("product name test1")
                .price(0.5)
                .category(Category.builder().categoryId(1).build())
                .description("description test1")
                .build();
        Product product2 = Product.builder()
                .productId(9)
                .name("product name test2")
                .price(0.9)
                .category(Category.builder().categoryId(2).build())
                .description("description test2")
                .build();
        Set<Product> actual = new HashSet<>();
        actual.add(product1);
        actual.add(product2);
        Set<Product> expected = productRepository.findProductsByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(searchKey, searchKey1);
        assertEquals(actual, expected);
    }

//    @Test
//    void findProductsByCategoryId(Pageable pageable) {
//        List<Product> actual = productRepository.findProductsByCategoryIdWithPageable(1, pageable);
//        List<Product> expected = Collections.emptyList();
//        assertEquals(actual, expected);
//
//    }
}