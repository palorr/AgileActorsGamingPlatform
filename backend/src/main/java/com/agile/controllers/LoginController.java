package com.agile.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static com.agile.handlers.UriPaths.LOGIN_URI;

@Controller
public class LoginController {

    @GetMapping(value = LOGIN_URI)
    public ModelAndView loadLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }

    /*Notice it only handles the GET request method, by returning the view with
    an optional parameter error in the model. The POST portion and actual handling
    of the form, will be done by Spring Security.*/

}
