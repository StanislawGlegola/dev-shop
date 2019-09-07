package com.devshop.devshop.repository;

import com.devshop.devshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  productRepository extends JpaRepository<Product, Long> {
}
