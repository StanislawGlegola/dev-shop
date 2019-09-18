package com.devshop.devshop.repository;

import com.devshop.devshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryId(Long id);

    void delete(Product product);

}
