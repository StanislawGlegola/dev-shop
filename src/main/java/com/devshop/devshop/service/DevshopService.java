package com.devshop.devshop.service;

import com.devshop.devshop.exception.OrderItemNotFoundException;
import com.devshop.devshop.model.*;
import com.devshop.devshop.repository.CategoryRepository;
import com.devshop.devshop.repository.OrderItemRepository1;
import com.devshop.devshop.repository.OrdersRepository;
import com.devshop.devshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevshopService {
    private final CategoryRepository categoryRepository;
    private final OrderItemRepository1 orderItemRepository1;
    private final ProductRepository productRepository;
    private final OrdersRepository ordersRepository;

    public DevshopService(CategoryRepository categoryRepository, OrderItemRepository1 orderItemRepository1, ProductRepository productRepository, OrdersRepository ordersRepository) {
        this.categoryRepository = categoryRepository;
        this.orderItemRepository1 = orderItemRepository1;
        this.productRepository = productRepository;
        this.ordersRepository = ordersRepository;
    }

    public List<Category> findAll() {
        List<Category> allCategories = categoryRepository.findAll();
        return allCategories;
    }

    public List<OrderItem> productsInCart() {
        List<OrderItem> orderedItems = orderItemRepository1.findAll();
        return orderedItems;
    }

    public List<Product> printProductsFromCategories(Long categoryid) {
        List<Product> printProducts = productRepository.findByCategoryId(categoryid);
        return printProducts;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public Product findProductById(int productId) {
        return productRepository.findById(productId).orElseThrow(() -> new RuntimeException(""));
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
        return orderItemRepository1.save(orderItem);
    }

    /* public List<OrderItem> findAllOrderItemsByOrder(int ordersId) {
        return orderItemRepository1.findByOrders(ordersId);

    }*/

    /* public List<OrderItem> findAllProductFromOrder(){
        return orderItemRepository1.findAll();
    }*/

    public List<OrderItem> findProductsFromOrder(Long ordersId) {
        return orderItemRepository1.findByOrders(ordersId);
    }

    //TODO  obsłużyć wyjątek w przypadku gdy w FindOrderByUsername zwróci null, do poprawienia
    public Orders findOrderByUsername(User user) {
        Orders readyOrder;
        String username = user.getUsername();
        Orders order = ordersRepository.FindOrderByUsername(username);
        if(order !=null){
            readyOrder = order;
        }else {
            readyOrder = new Orders();
            readyOrder.setUser(user);
            readyOrder.setStatus(false);
            addOrders(readyOrder);
        }
        return readyOrder;
    }

    public void deleteOrderItemById(Long orderItemId) {
        orderItemRepository1.deleteById(orderItemId);
    }

    public Orders findOrderByOrderItemId(Long orderItemId) {
        Optional<OrderItem> byId = orderItemRepository1.findById(orderItemId);
        if(byId.isPresent()){
            OrderItem orderItem = byId.get();
            Product product = productRepository.findById(orderItem.getProduct().getId()).get();
            product.setAmount(product.getAmount() + 1);
            productRepository.save(product);
            return orderItem.getOrders();
        }
        else {
            throw new OrderItemNotFoundException("No such order.");
        }
    }
}