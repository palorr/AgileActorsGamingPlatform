package com.agile.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.agile.model.User;
import com.agile.repositories.UserRepository;

@Controller
public class AdminUserController {
    @Autowired
    private UserRepository userRepository;

    private static final String USERS_DATA= "users";
    private static final String USER_DATA= "user";

    @GetMapping(value = "/admin/users")
    public String users(ModelMap model) {
        List<User> users = userRepository.findAll();
        model.addAttribute(USERS_DATA, users);
        return "users";
    }

    @GetMapping(value = "/admin/users/{id}")
    public String user_details(@PathVariable(value="id") Integer id, ModelMap model) {
        User user = userRepository.findOne(id);
        model.addAttribute(USER_DATA, user);
        return "user_details";
    }
}
