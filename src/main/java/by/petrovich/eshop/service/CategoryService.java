package by.petrovich.eshop.service;

import by.petrovich.eshop.model.Category;
import by.petrovich.eshop.model.User;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    User save(Category category);

    Optional<Category> findById(Integer id);
}
