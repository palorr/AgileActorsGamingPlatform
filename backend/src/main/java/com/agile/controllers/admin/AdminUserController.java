package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.*;
import static com.agile.resources.UriPaths.*;

@Controller
public class AdminUserController {
    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private WebAppConfigHandler webConfHandler;

    private static final String USERS_DATA= "users";
    private static final String USER_DATA= "user";

    @GetMapping(value = ADMIN_USERS_URI)
    public ModelAndView loadUsersPage() {
        ModelAndView modelAndView = getModelAndView("users");
        modelAndView.addObject(ADMIN_UPDATE_USER_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_UPDATE_USER_URI_PARAM));
        modelAndView.addObject(ADMIN_DELETE_USER_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_DELETE_USER_URI_PARAM));
        modelAndView.addObject(USERS_DATA, userService.fetchUsers());
        return modelAndView;
    }

    @GetMapping(value = ADMIN_USERS_ID_URI)
    public ModelAndView loadUserDetailsPage(@PathVariable(value="id") Integer id) {
        ModelAndView modelAndView = getModelAndView("user_details");
        modelAndView.addObject(USER_DATA, userService.getUser(id));
        modelAndView.addObject(ADMIN_USERS_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_USERS_URI_PARAM));
        modelAndView.addObject(ADMIN_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_URI_PARAM));
        modelAndView.addObject(ADMIN_GAMES_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_GAMES_URI_PARAM));
        modelAndView.addObject(LOGOUT_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(LOGOUT_URI_PARAM));
        return modelAndView;
    }

    private ModelAndView getModelAndView(String viewName) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(LOGOUT_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(LOGOUT_URI_PARAM));
        modelAndView.addObject(ADMIN_USERS_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_USERS_URI_PARAM));
        return modelAndView;
    }
}
