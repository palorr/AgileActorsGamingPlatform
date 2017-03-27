package com.agile.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.agile.models.User;
import com.agile.repositories.UserRepository;

@Controller
public class AdminUserController {
    @Autowired
    private UserRepository userRepository;

    private static final String USERS_DATA= "users";
    private static final String USER_DATA= "user";

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String users(ModelMap model) {
        List<User> users = userRepository.findAll();
        model.addAttribute(USERS_DATA, users);
        return "users";
    }

    @RequestMapping(value = "/admin/users/{id}", method = RequestMethod.GET)
    public String user_details(@PathVariable(value="id") Integer id, ModelMap model) {
        User user = userRepository.findOne(id);
        model.addAttribute(USER_DATA, user);
        return "user_details";
    }
}