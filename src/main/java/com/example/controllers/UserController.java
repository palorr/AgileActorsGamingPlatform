package com.example.controllers;

import com.example.models.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    private static final String USERS_DATA= "users";
    private static final String USER_DATA= "user";

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String users(ModelMap model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute(USERS_DATA, users);
        return "users";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String user_details(@PathVariable(value="id") Integer id, ModelMap model) {
        User user = userRepository.findOne(id);
        model.addAttribute(USER_DATA, user);
        return "user_details";
    }
}
