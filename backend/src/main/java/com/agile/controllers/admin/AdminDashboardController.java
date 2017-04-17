package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.agile.handlers.UriPaths.*;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_GAMES_URI;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_USERS_URI;

@Controller
public class AdminDashboardController {

    @Autowired
    private WebAppConfigHandler webAppConfigHandler;

  @GetMapping(value = ADMIN_PATH)
    public ModelAndView dashboard(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("dashboard");
      modelAndView.addObject(ADMIN_USERS_URI.getWebConfigParam(),
              webAppConfigHandler.getWebAppPath(ADMIN_USERS_URI));
      modelAndView.addObject(ADMIN_GAMES_URI.getWebConfigParam(),
              webAppConfigHandler.getWebAppPath(ADMIN_GAMES_URI));
        return modelAndView;
    }
}
