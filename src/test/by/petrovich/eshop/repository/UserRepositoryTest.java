package by.petrovich.eshop.repository;

import by.petrovich.eshop.EShopApplication;
import by.petrovich.eshop.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(classes = EShopApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = User.builder()
                .name("John")
                .email("john@gmail.com")
                .password("qwerty1990")
                .birthDate(LocalDate.of(1990, 1, 1))
                .balance(0.9)
                .build();
        User savedUser = userRepository.save(user);
        Optional<User> existedUser = userRepository.findById(savedUser.getUserId());
        assertEquals(savedUser, existedUser.get());
    }

    @Test
    public void testFindById() {
        int id = 1;
        User actualUser = User.builder()
                .userId(1)
                .name("Wade")
                .password("Williams")
                .email("test@mail.com")
                .birthDate(LocalDate.of(1990, 1, 1))
                .balance(0.5)
                .orders(new HashSet<>())
                .build();

        Optional<User> expectedUser = userRepository.findById(id);
        assertEquals(expectedUser.get(), actualUser);
    }

    @Test
    public void testFindByName() {
        String name = "Wade";
        User actualUser = User.builder()
                .userId(1)
                .name("Wade")
                .password("Williams")
                .email("test@mail.com")
                .birthDate(LocalDate.of(1990, 1, 1))
                .balance(0.5)
                .orders(new HashSet<>())
                .build();

        Optional<User> expectedUser = userRepository.findByName(name);
        assertEquals(expectedUser.get(), actualUser);
    }
}
