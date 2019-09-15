package com.devshop.devshop.controller;

import com.devshop.devshop.model.Category;
import com.devshop.devshop.model.OrderItem;
import com.devshop.devshop.model.Orders;
import com.devshop.devshop.model.Product;
import com.devshop.devshop.service.DevshopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        return modelAndView;
    }
    @PostMapping("/newProduct")
    public String addNewProductToDB(Product product){
        devshopService.addProduct(product);
        return "redirect:/admin";
    }

//    @PostMapping("/cart")//value =
//    public ModelAndView addProductToCart(){
//
//        return new ModelAndView("cart");
//    }


    @GetMapping("/cart/{ordersId}")
    public ModelAndView getCartLista(@PathVariable Long ordersId){

      //  List<OrderItem> orderedItems=devshopService.FindAllOrderItemsByOrder(ordersId);
        List<OrderItem> orderedItems= devshopService.FindAllProductFromOrder();
        ModelAndView modelAndView=new ModelAndView("cart");
        modelAndView.addObject("orderItems",orderedItems);

        return modelAndView;
    }


    @GetMapping("/addToCart/{id}")
    public String addProductapplyToCart(@PathVariable int id) {  //zad3

        // User session Needed!
        Orders order = new Orders();
        //dodanie ordera

        Orders saveorder = devshopService.addOrders(order);
        Product product = devshopService.findProduct(id);
        //save order repository dodac metody w serwisie wykorzystująć  repository, dodać order do bazy danych a nastepnie zwrocic order id do productCart redirect
        //item.setProduct(product);

        OrderItem orderItem = new OrderItem(product.getAmount(),saveorder,product);
        devshopService.addOrderItem(orderItem);

        return "redirect:/cart/" + saveorder.getId();
    }

}
