package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import static com.agile.handlers.UriPaths.*;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_USERS_URI_PARAM;

@Controller
public class AdminUserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebAppConfigHandler webAppConfigHandler;

    private static final String USERS_DATA= "users";
    private static final String USER_DATA= "user";

    @GetMapping(value = ADMIN_USERS_URI)
    public ModelAndView loadUsersPage() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject(USERS_DATA, userRepository.findAll());
        return modelAndView;
    }

    @GetMapping(value = ADMIN_USERS_ID_URI)
    public ModelAndView loadUserDetailsPage(@PathVariable(value="id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("user_details");
        modelAndView.addObject(USER_DATA, userRepository.findOne(id));
        modelAndView.addObject(ADMIN_USERS_URI_PARAM.getWebConfigParam(),
                webAppConfigHandler.getWebAppPath(ADMIN_USERS_URI_PARAM));
        return modelAndView;
    }
}
