package com.agile.controllers;

import com.agile.model.User;
import com.agile.validator.LoggednInUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class LoginController {

    @GetMapping(value = "/login")
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        return new ModelAndView("login", "error", error);
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied(@RequestParam Optional<String> error) {

        ModelAndView model = new ModelAndView();
        model.addObject("error", error);
        model.setViewName("login");
        return model;

    }

    /*Notice it only handles the GET request method, by returning the view with
    an optional parameter error in the model. The POST portion and actual handling
    of the form, will be done by Spring Security.*/

}
