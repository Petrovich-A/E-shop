package by.petrovich.eshop.repository;

import by.petrovich.eshop.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RoleRepositoryTest {
    @Autowired
    private RoleRepository repository;

    @Test
    void findByName() {
        Role expected = new Role();
        expected.setName("user");

        Role actual = repository.findByName(expected.getName());
        assertEquals(actual, expected);
    }
}