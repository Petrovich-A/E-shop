package by.petrovich.eshop.service;

import by.petrovich.eshop.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(Integer id);
}
