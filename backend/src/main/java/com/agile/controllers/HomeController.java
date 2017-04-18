package com.agile.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static com.agile.resources.UriPaths.*;

@Controller
public class HomeController {

    @RequestMapping({ HOME_ONE_URI, HOME_TWO_URI })
    public ModelAndView loadHomePage(@RequestParam Optional<String> error) {
        return new ModelAndView("home", "error", error);
    }
}
