package by.petrovich.eshop.service.impl;

import by.petrovich.eshop.model.Category;
import by.petrovich.eshop.model.Product;
import by.petrovich.eshop.model.User;
import by.petrovich.eshop.repository.CategoryRepository;
import by.petrovich.eshop.repository.ProductRepository;
import by.petrovich.eshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public User save(Category category) {
        return null;
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Product> findProductsByCategoryId(Integer categoryId) {
        return productRepository.findProductsByCategoryId(categoryId);
    }

}
