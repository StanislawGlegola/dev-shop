package com.devshop.devshop.service;

import com.devshop.devshop.model.Category;
import com.devshop.devshop.model.OrderItem;
import com.devshop.devshop.model.Orders;
import com.devshop.devshop.model.Product;
import com.devshop.devshop.repository.CategoryRepository;
import com.devshop.devshop.repository.OrderItemRepository;
import com.devshop.devshop.repository.OrdersRepository;
import com.devshop.devshop.repository.ProductRepository;
import org.springframework.core.annotation.Order;
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

    public List<Product> printProductsFromCategories(Long id) {
        List<Product> printProducts = productRepository.findByCategoryId(id);
        return printProducts;
    }

    //dodanne
    public Optional<Product> addProductToCart(Product product) {
       // List<Product> products = productRepository.findAll();
        int id = product.getId();
        Optional<Product> productsInCart  = productRepository.findById(id);
        return  productsInCart;
    }

    public Product findProduct(int id){

        Product product  = productRepository.findById(id).orElseThrow((() -> new RuntimeException()));
        return product;
    }


    public Orders addOrders(Orders order) {
        return ordersRepository.save(order);
    }

    public OrderItem addOrderItem(OrderItem orderItem){
        return orderItemRepository.save(orderItem);
    }


    public List<OrderItem> FindAllOrderItemsByOrder(Long ordersId) {
        return orderItemRepository.findByOrders(ordersId);

    }
    public List<OrderItem> FindAllProductFromOrder(){
        return orderItemRepository.findAll();
    }
}