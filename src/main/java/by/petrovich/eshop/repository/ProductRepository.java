package by.petrovich.eshop.repository;

import by.petrovich.eshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String name);

    //    List<Product> findAllByCategory(Category category);
    @Query("SELECT p FROM Product p WHERE p.category.categoryId =:categoryId")
    List<Product> findProductsByCategoryId(Integer categoryId);
}
