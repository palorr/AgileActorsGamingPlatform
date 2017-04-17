package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.agile.handlers.UriPaths.ADMIN_URI;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_GAMES_URI_PARAM;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_USERS_URI_PARAM;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.LOGOUT_URI_PARAM;

@Controller
public class AdminDashboardController {

    @Autowired
    private WebAppConfigHandler webAppConfigHandler;

    @GetMapping(value = ADMIN_URI)
    public ModelAndView loadDashboard() {
        ModelAndView modelAndView = new ModelAndView("dashboard");
        modelAndView.addObject(ADMIN_USERS_URI_PARAM.getWebConfigParam(),
                webAppConfigHandler.getWebAppPath(ADMIN_USERS_URI_PARAM));
        modelAndView.addObject(LOGOUT_URI_PARAM.getWebConfigParam(),
                webAppConfigHandler.getWebAppPath(LOGOUT_URI_PARAM));
        modelAndView.addObject(ADMIN_GAMES_URI_PARAM.getWebConfigParam(),
                webAppConfigHandler.getWebAppPath(ADMIN_GAMES_URI_PARAM));
        return modelAndView;
    }
}
