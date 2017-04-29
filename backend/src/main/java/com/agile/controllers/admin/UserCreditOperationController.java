package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.services.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.*;
import static com.agile.resources.UriPaths.ADMIN_USER_CREDITS_URI;

@Controller
public class UserCreditOperationController {

    @Autowired
    private WebAppConfigHandler webConfHandler;

    @Autowired
    private OperationsService operationsService;

    private static final String OPERATIONS_DATA= "operations";

    @GetMapping(value = ADMIN_USER_CREDITS_URI)
    public ModelAndView loadOperations() {
        ModelAndView modelAndView = getModelAndView("user_credit_operations");
        modelAndView.addObject(OPERATIONS_DATA, operationsService.fetchCreditOperations());
        return modelAndView;
    }

    private ModelAndView getModelAndView(String viewName) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(ADMIN_GAMES_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_GAMES_URI_PARAM));
        modelAndView.addObject(ADMIN_USERS_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_USERS_URI_PARAM));
        modelAndView.addObject(ADMIN_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_URI_PARAM));
        modelAndView.addObject(LOGOUT_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(LOGOUT_URI_PARAM));
        return modelAndView;
    }
}
