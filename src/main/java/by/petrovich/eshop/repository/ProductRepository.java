package by.petrovich.eshop.repository;

import by.petrovich.eshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.category.categoryId =:categoryId")
    List<Product> findProductsByCategoryId(Integer categoryId);

    Set<Product> findProductsByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String searchKey, String searchKey1);

    Optional<Product> findProductByProductId(Integer productId);

    Page<Product> findAllByCategory_CategoryId(Integer categoryId, Pageable pageable);

}
