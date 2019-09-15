package com.devshop.devshop.controller;

import com.devshop.devshop.model.Category;
import com.devshop.devshop.model.OrderItem;
import com.devshop.devshop.model.Product;
import com.devshop.devshop.service.DevshopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    private final DevshopService devshopService;

    public AppController(DevshopService devshopService) {
        this.devshopService = devshopService;
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
        modelAndView.addObject("edit", false);
        return modelAndView;
    }

    @PostMapping("/newProduct")
    public String addNewProductToDB(Product product){
        devshopService.addProduct(product);
        return "redirect:/admin";
    }

    @GetMapping("/admin/{productId}")
    public ModelAndView updateProductListView(@PathVariable int productId) {
        ModelAndView modelAndView = new ModelAndView("admin");
        Product foundProduct = devshopService.findProductById(productId);
        modelAndView.addObject("product", foundProduct);
        modelAndView.addObject("edit", true);
        return modelAndView;
    }
}