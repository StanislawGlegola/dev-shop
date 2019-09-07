package com.devshop.devshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @GetMapping("/")
    public ModelAndView getHomePage() {
        return new ModelAndView("home");
    }

    @GetMapping("/admin")
    public ModelAndView getAdminPage() {
        return new ModelAndView("admin");
    }

    @GetMapping("/accessDenied")
    public ModelAndView getAccessDeniedPage() {
        return new ModelAndView("accessDenied");
    }
}