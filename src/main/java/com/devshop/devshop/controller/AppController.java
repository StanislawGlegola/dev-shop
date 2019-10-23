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
    public ModelAndView getProductListByCategories(@PathVariable int id) {
        User user = sessionUserProvider.getLoggedUser();
        List<Product> productsList = devshopService.printProductsFromCategories(id);
        ModelAndView modelAndView = new ModelAndView("productList");
        modelAndView.addObject("products", productsList);

        if (user != null) {
            if (user.getRole().getAuthority().toUpperCase().equals("ADMIN")) {
                modelAndView.addObject("isAdmin", true);
            } else if (user.getRole().getAuthority().toUpperCase().equals("USER")) {
                modelAndView.addObject("isAdmin", false);
            }
        }
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
    public ModelAndView viewAdminPanel() {
        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("edit", false);
        return modelAndView;
    }

   @GetMapping("/admin/{productId}")
    public ModelAndView adminEditingProductPanel(@PathVariable int productId) {
        ModelAndView modelAndView = new ModelAndView("admin");
        Product foundProduct = devshopService.findProductById(productId);
        modelAndView.addObject("product", foundProduct);
        modelAndView.addObject("edit", true);
        return modelAndView;
    }

    @PostMapping("/newProduct")
    public String addNewProductToDB(@ModelAttribute Product product) {
        devshopService.addProduct(product);
        return "redirect:/productList/" + product.getCategory().getId();
    }

    @GetMapping("/cart/{ordersId}")
    public ModelAndView viewOrderItemsList(@PathVariable int ordersId) {
        List<OrderItem> orderedItems = devshopService.findProductsFromOrder(ordersId);
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("orderItems", orderedItems);
        return modelAndView;
    }

    @GetMapping("/addToCart/{id}")
    public String addProductFromProductListToCart(@PathVariable int id) {
        User user = sessionUserProvider.getLoggedUser();
        Orders orders = devshopService.findOrderByUsername(user);
        Product product = devshopService.findProductById(id);

        if (user.getRole().getAuthority().equals("USER")) {
            int amountOfProductsToMoveFromProdListToCart = 1;
            product.setAmount(product.getAmount() - amountOfProductsToMoveFromProdListToCart);
            OrderItem orderItem = new OrderItem(amountOfProductsToMoveFromProdListToCart, orders, product);
            devshopService.addOrderItem(orderItem);
            return "redirect:/cart/" + orders.getId();
        } else {
            return "redirect:/cart/" + orders.getId();
        }
    }

    @GetMapping("/removeFromCart/{orderItemId}")
    public String removeFromCart(@PathVariable int orderItemId) {
        Orders orders = devshopService.findOrderByOrderItemId(orderItemId);

        // 1. stworzyc dobre obiekty
        OrderItem orderItem = devshopService.findOrderItemsById(orderItemId);
        Product product = orderItem.getProduct();
        // 2. logika cofania amount do obiektu
        int amountReduce = 1;
        int amountInOrder = orderItem.getAmount();
        int amountInProduct = product.getAmount();
        product.setAmount(amountInOrder+amountInProduct-amountReduce);
        // 3. zapisanie tego
        devshopService.deleteOrderItemById(orderItemId);
        return "redirect:/cart/" + orders.getId();
    }

    @GetMapping("/remove/{id}")
    public String removeProductFromProductsList(@PathVariable int id) {
        Product product = (devshopService.findProductById(id));
        devshopService.removeProduct(product);
        return "redirect:/productList/" + product.getCategory().getId();
    }
}