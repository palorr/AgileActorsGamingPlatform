package com.agile.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class HomeController {

    @RequestMapping("/")//({ "/home", "/contact" })
    public ModelAndView getHomePage1(@RequestParam Optional<String> error) {
        return new ModelAndView("home", "error", error);
    }

    @RequestMapping("/home")
    public ModelAndView getHomePage2(@RequestParam Optional<String> error) {
        return new ModelAndView("home", "error", error);
    }
}
