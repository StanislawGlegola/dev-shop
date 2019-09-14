package com.devshop.devshop.service;

import com.devshop.devshop.model.Category;
import com.devshop.devshop.model.Order;
import com.devshop.devshop.model.OrderItem;
import com.devshop.devshop.model.Product;
import com.devshop.devshop.repository.CategoryRepository;
import com.devshop.devshop.repository.OrderItemRepository;
import com.devshop.devshop.repository.OrderRepository;
import com.devshop.devshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevshopService {
    private final CategoryRepository categoryRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private Product product;
    private OrderItem orderItem;
    private final OrderRepository orderRepository;
    private Order order;


    public DevshopService(CategoryRepository categoryRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.categoryRepository = categoryRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.product=product;
        this.orderItem = orderItem;
        this.orderRepository = orderRepository;
    }

    public List<Category> findAll() {
        List<Category> allCategories = categoryRepository.findAll();
        return allCategories;
    }

    public List<OrderItem> productsInCart() {
        List<OrderItem> orderedItems = orderItemRepository.findAll();
        return orderedItems;
    }

    public List<Product> printProductsFromCategories(Long categoryid) {
        List<Product> printProducts = productRepository.findByCategoryId(categoryid);
        return printProducts;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }
}