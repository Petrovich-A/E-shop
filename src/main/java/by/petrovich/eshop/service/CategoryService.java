package by.petrovich.eshop.service;

import by.petrovich.eshop.entity.Category;
import by.petrovich.eshop.entity.Product;
import by.petrovich.eshop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Page<Product> findAll(Pageable paging);

    User save(Category category);

    Page findProductsByCategoryId(Integer categoryId, Pageable pageable);

}
