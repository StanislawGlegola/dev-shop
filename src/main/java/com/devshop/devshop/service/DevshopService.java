package com.devshop.devshop.service;

import com.devshop.devshop.model.Category;
import com.devshop.devshop.model.OrderItem;
import com.devshop.devshop.repository.CategoryRepository;
import com.devshop.devshop.repository.OrderItemRepository;
import com.devshop.devshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevshopService {
    private final CategoryRepository categoryRepository;
    private final OrderItemRepository orderItemRepository;

    public DevshopService(CategoryRepository categoryRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository, OrderItem orderItem) {
        this.categoryRepository = categoryRepository;
        this.orderItemRepository = orderItemRepository;

    }

    public List<Category> findAll() {
        List<Category> allCategories = categoryRepository.findAll();
        return allCategories;
    }

    public List<OrderItem> productsInCart(){
        List<OrderItem>orderedItems=orderItemRepository.findAll();
        return orderedItems;
    }
}