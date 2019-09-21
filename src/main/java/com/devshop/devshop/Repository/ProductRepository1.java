package com.devshop.devshop.repository;

import com.devshop.devshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository1 extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryId(Long id);
}