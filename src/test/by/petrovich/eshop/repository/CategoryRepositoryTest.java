package by.petrovich.eshop.repository;

import by.petrovich.eshop.EShopApplication;
import by.petrovich.eshop.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = EShopApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testSaveCategory() {
        int id = 1;
        Category category = Category.builder()
                .name("category1")
                .rating(1)
                .build();
        Optional<Category> expectedCategory = categoryRepository.findById(id);
        assertEquals(expectedCategory.orElse(null), category);
    }

    @Test
    public void testFindCategoryById() {
        int id = 1;
        Category category = Category.builder()
                .categoryId(1)
                .name("category1")
                .rating(1)
                .build();
        Optional<Category> expectedCategory = categoryRepository.findById(id);
        assertEquals(expectedCategory.orElse(null), category);
    }

    @Test
    public void testFindAll() {
        List<Category> actualCategories = new ArrayList<>();
        Category category1 = Category.builder()
                .categoryId(1)
                .name("category1")
                .rating(1)
                .build();
        Category category2 = Category.builder()
                .categoryId(2)
                .name("category2")
                .rating(1)
                .build();
        Category category3 = Category.builder()
                .categoryId(3)
                .name("category3")
                .rating(1)
                .build();
        actualCategories.add(category1);
        actualCategories.add(category2);
        actualCategories.add(category3);
        List<Category> expectedCategories = categoryRepository.findAll();
        assertEquals(expectedCategories, actualCategories);
    }

}