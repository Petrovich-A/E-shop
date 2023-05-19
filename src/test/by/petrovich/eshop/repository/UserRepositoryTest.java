package by.petrovich.eshop.repository;

import by.petrovich.eshop.EShopApplication;
import by.petrovich.eshop.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;
import java.util.Optional;


@SpringBootTest(classes = EShopApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setName("John");
        user.setEmail("john@gmail.com");
        user.setPassword("qwerty1990");
        user.setBirthDate(LocalDate.of(1990, 1, 1));
        user.setBalance(50.25);

        User savedUser = userRepository.save(user);
        Optional<User> existUser = userRepository.findById(savedUser.getUserId());
        Assertions.assertEquals(savedUser, existUser.orElse(null));

    }

    @Test
    public void findById() {
        int id = 1;
        User user = User.builder()
                .userId(1)
                .name("Wade")
                .password("Williams")
                .email("test@mail.com")
                .birthDate(LocalDate.of(1990, 1, 1))
                .balance(0.5)
                .build();

        Optional<User> expectedUser = userRepository.findById(id);
        Assertions.assertEquals(expectedUser.orElse(null), user);
    }

    @Test
    public void findByName() {
        String name = "Wade";
        User user = User.builder()
                .userId(1)
                .name("Wade")
                .password("Williams")
                .email("test@mail.com")
                .birthDate(LocalDate.of(1990, 1, 1))
                .balance(0.5)
                .build();

        Optional<User> expectedUser = userRepository.findByName(name);
        Assertions.assertEquals(expectedUser.orElse(null), user);
    }
}
