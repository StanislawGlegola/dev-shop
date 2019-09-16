package com.devshop.devshop.controller;

import com.devshop.devshop.model.*;
import com.devshop.devshop.service.DevshopService;
import com.devshop.devshop.service.SessionUserProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    private final DevshopService devshopService;
    private final SessionUserProvider sessionUserProvider;

    public AppController(DevshopService devshopService, SessionUserProvider sessionUserProvider) {
        this.devshopService = devshopService;
        this.sessionUserProvider = sessionUserProvider;
    }

    @GetMapping("/")
    public ModelAndView getCategoriesScreen() {

        List<Category> categories = devshopService.findAll();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("categories", categories);

        return modelAndView;
    }

    @GetMapping("/cart")
    public ModelAndView getCartScreen() {
        List<OrderItem> orderedItems = devshopService.productsInCart();
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("orderItems", orderedItems);

        return modelAndView;
    }

    @GetMapping("/cart/add/{productId}/{orderId}")
    public void addProductToCart(@PathVariable Long orderId, @PathVariable Long productId) {
    }

    @GetMapping("/productList/{id}")
    public ModelAndView getProductListByCategories(@PathVariable Long id) {
        List<Product> productsList = devshopService.printProductsFromCategories(id);
        ModelAndView modelAndView = new ModelAndView("productList");
        modelAndView.addObject("products", productsList);

        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @GetMapping("/accessDenied")
    public ModelAndView getAccessDeniedPage() {
        return new ModelAndView("accessDenied");
    }

    @GetMapping("/admin")
    public ModelAndView viewAdminProductAddFormular() {
        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }
    @PostMapping("/newProduct")
    public String addNewProductToDB(Product product){
        devshopService.addProduct(product);
        return "redirect:/admin";
    }

    @GetMapping("/cart/{ordersId}")
    public ModelAndView getCartLista(@PathVariable Long ordersId){
        List<OrderItem> orderedItems= devshopService.findProductsFromOrder(ordersId);
        ModelAndView modelAndView=new ModelAndView("cart");
        modelAndView.addObject("orderItems",orderedItems);

        return modelAndView;
    }

    @GetMapping("/addToCart/{id}")
    public String addProductToCart(@PathVariable int id) {  //zad3
        // User session Needed!
        //znaleźć zamówienie uzytkownika,jeżeli istnieje i status = false(niezrealizowane)
        //uzyć id tego zamowenia i dopisywać produkty jezlei nie istnieje lub status = true(zrealizowane)- utworzyc nowe zamowienie i dodać produkty.
        //save order repository dodac metody w serwisie wykorzystująć  repository, dodać order do bazy danych a nastepnie zwrocic order id do productCart redirect

        User user = sessionUserProvider.getLoggedUser();
        Orders orders = devshopService.findOrderByUsername(user);
        Product product = devshopService.findProduct(id);
        OrderItem orderItem = new OrderItem(product.getAmount(),orders,product);
        devshopService.addOrderItem(orderItem);
        return "redirect:/cart/" + orders.getId();
    }

}