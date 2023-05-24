package by.petrovich.eshop.service;

import by.petrovich.eshop.model.Product;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(Integer id);

    Set<Product> searchProductsByNameAndDescription(String searchKey);

}
