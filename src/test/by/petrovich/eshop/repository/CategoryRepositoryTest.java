package by.petrovich.eshop.repository;

import by.petrovich.eshop.EShopApplication;
import by.petrovich.eshop.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

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


}