package by.petrovich.eshop.repository;

import by.petrovich.eshop.EShopApplication;
import by.petrovich.eshop.entity.Image;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = EShopApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ImageRepositoryTest {
    @Autowired
    private ImageRepository imageRepository;

    @Test
    void testFindByImageId() {
        int id = 1;
        Image expected = Image.builder()
                .productId(1)
                .link("/img/error.png")
                .build();
        Optional<Image> image = imageRepository.findImageByProductId(id);
        Image actual = image.get();
        assertEquals(actual, expected);
    }
}