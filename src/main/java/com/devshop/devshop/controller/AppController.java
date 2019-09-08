package com.devshop.devshop.controller;

import com.devshop.devshop.model.Category;
import com.devshop.devshop.service.DevshopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

        List<Category>categories=devshopService.getCategoriesList();
        ModelAndView modelAndView=new ModelAndView("home");
        modelAndView.addObject("categories", categories);


        return modelAndView;
    }
}
