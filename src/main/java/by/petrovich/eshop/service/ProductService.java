package by.petrovich.eshop.service;

import by.petrovich.eshop.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(Integer id);

    Set<Product> searchProductsByNameAndDescription(String searchKey);

    Page<Product> findPaginated(Pageable pageable);

}
