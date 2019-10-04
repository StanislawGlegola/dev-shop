package com.devshop.devshop.controller;

import com.devshop.devshop.model.*;
import com.devshop.devshop.service.DevshopService;
import com.devshop.devshop.service.SessionUserProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        modelAndView.addObject("edit", false);
        return modelAndView;
    }

    @PostMapping("/newProduct")
    public String addNewProductToDB(@ModelAttribute Product product) {
        devshopService.addProduct(product);
        return "redirect:/productList/" + product.getCategory().getId();
    }

    @GetMapping("/admin/{productId}")
    public ModelAndView updateProductListView(@PathVariable int productId) {
        ModelAndView modelAndView = new ModelAndView("admin");
        Product foundProduct = devshopService.findProductById(productId);
        modelAndView.addObject("product", foundProduct);
        modelAndView.addObject("edit", true);
        return modelAndView;
    }

    @GetMapping("/cart/{ordersId}")
    public ModelAndView getCartLista(@PathVariable Long ordersId) {
        List<OrderItem> orderedItems = devshopService.findProductsFromOrder(ordersId);
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("orderItems", orderedItems);
        return modelAndView;
    }

    @GetMapping("/addToCart/{id}")
    public String addProductToCart(@PathVariable int id) {  //zad3
        //User session Needed!
        //znaleźć zamówienie uzytkownika,jeżeli istnieje i status = false(niezrealizowane)
        //uzyć id tego zamowenia i dopisywać produkty jezlei nie istnieje lub status = true(zrealizowane)- utworzyc nowe zamowienie i dodać produkty.
        //save order repository dodac metody w serwisie wykorzystująć  repository, dodać order do bazy danych a nastepnie zwrocic order id do productCart redirect
        User user = sessionUserProvider.getLoggedUser();
        Orders orders = devshopService.findOrderByUsername(user);
        Product product = devshopService.findProductById(id);
        if (product.getAmount() == 0) {
            return "redirect:/productList/" + product.getCategory().getId();
        } else {
            product.setAmount(product.getAmount() - 1);
            OrderItem orderItem = new OrderItem(1, orders, product);
            devshopService.addOrderItem(orderItem);
            return "redirect:/cart/" + orders.getId();
        }
    }

    @GetMapping("/removeFromCart/{orderItemId}")
    public String removeFromCart(@PathVariable Long orderItemId) {
        Orders orders = devshopService.findOrderByOrderItemId(orderItemId);
        devshopService.deleteOrderItemById(orderItemId);
        return "redirect:/cart/" + orders.getId();
    }

    @GetMapping("/remove/{id}")
    public String removePosition(@PathVariable int id) {
        Product product = (devshopService.findProductById(id));
        devshopService.removeProduct(product);
        return "redirect:/productList/" + product.getCategory().getId();
    }
}