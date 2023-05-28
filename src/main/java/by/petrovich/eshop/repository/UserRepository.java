package by.petrovich.eshop.repository;

import by.petrovich.eshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByName(String name);

    Optional<User> findByNameAndPassword(String name, String password);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);


}
