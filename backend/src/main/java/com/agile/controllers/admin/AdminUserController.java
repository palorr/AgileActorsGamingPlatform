package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import static com.agile.handlers.UriPaths.ADMIN_USERS_ID_PATH;
import static com.agile.handlers.UriPaths.ADMIN_USERS_PATH;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_USERS_URI;

@Controller
public class AdminUserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebAppConfigHandler webAppConfigHandler;

    private static final String USERS_DATA= "users";
    private static final String USER_DATA= "user";

    @GetMapping(value = ADMIN_USERS_PATH)
    public ModelAndView loadUsersPage() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject(USERS_DATA, userRepository.findAll());
        return modelAndView;
    }

    @GetMapping(value = ADMIN_USERS_ID_PATH)
    public ModelAndView loadUserDetailsPage(@PathVariable(value="id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("user_details");
        modelAndView.addObject(USER_DATA, userRepository.findOne(id));
        modelAndView.addObject(ADMIN_USERS_URI.getWebConfigParam(),
                webAppConfigHandler.getWebAppPath(ADMIN_USERS_URI));
        return modelAndView;
    }
}
