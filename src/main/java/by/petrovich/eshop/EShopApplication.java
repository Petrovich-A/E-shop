package by.petrovich.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(EShopApplication.class, args);
    }
}
