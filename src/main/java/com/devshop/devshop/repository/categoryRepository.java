package com.devshop.devshop.repository;

import com.devshop.devshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepository extends JpaRepository<Category, Long> {

}
