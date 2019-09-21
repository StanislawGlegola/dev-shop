package com.devshop.devshop.service;

import com.devshop.devshop.exception.ProductNotFoundException;
import com.devshop.devshop.model.*;
import com.devshop.devshop.repository.CategoryRepository;
import com.devshop.devshop.repository.OrderItemRepository;
import com.devshop.devshop.repository.OrdersRepository;
import com.devshop.devshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevshopService {
    private final CategoryRepository categoryRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;
    private final OrdersRepository ordersRepository;

    public DevshopService(CategoryRepository categoryRepository, OrderItemRepository orderItemRepository, ProductRepository productRepository, OrdersRepository ordersRepository) {
        this.categoryRepository = categoryRepository;
        this.orderItemRepository = orderItemRepository;
        this.productRepository = productRepository;
        this.ordersRepository = ordersRepository;
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

    public Product findProductById(int productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Id: "+productId+" is not found."));
    }

    //dodanne
    public Optional<Product> addProductToCart(Product product) {
        // List<Product> products = productRepository.findAll();
        int id = product.getId();
        Optional<Product> productsInCart = productRepository.findById(id);
        return productsInCart;
    }

    Orders addOrders(Orders order) {
        return ordersRepository.save(order);
    }

    public OrderItem addOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> findAllOrderItemsByOrder(Long ordersId) {
        return orderItemRepository.findByOrders(ordersId);
    }

    public List<OrderItem> findAllProductFromOrder() {
        return orderItemRepository.findAll();
    }

    public List<OrderItem> findProductsFromOrder(Long ordersId) {
        return orderItemRepository.findByOrders(ordersId);
    }

    //TODO  obsłużyć wyjątek w przypadku gdy w findOrderByUsername zwróci null, do poprawienia
    public Orders findOrderByUsername(User user) {
        Orders readyOrder;
        String username = user.getUsername();
        Orders order = ordersRepository.findOrderByUsername(username);
        if (order != null) {
            readyOrder = order;
        } else {
            readyOrder = new Orders();
            readyOrder.setUser(user);
            readyOrder.setStatus(false);
            addOrders(readyOrder);
        }
        return readyOrder;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void removeProduct(Product product) {
        productRepository.delete(product);
    }
}