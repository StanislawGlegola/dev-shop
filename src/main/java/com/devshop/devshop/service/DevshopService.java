package com.devshop.devshop.service;

import com.devshop.devshop.model.Category;
import com.devshop.devshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevshopService {
    private final CategoryRepository categoryRepository;

    public DevshopService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategoriesList() {
        List<Category> allCategories = categoryRepository.findAll();
        return allCategories;
    }
}
