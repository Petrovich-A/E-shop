package by.petrovich.eshop.service;

import by.petrovich.eshop.entity.Category;
import by.petrovich.eshop.entity.Product;
import by.petrovich.eshop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    User save(Category category);

    Optional<Category> findById(Integer id);

    Page<Product> findProductsByCategoryId(Integer categoryId, Pageable pageable);

}
