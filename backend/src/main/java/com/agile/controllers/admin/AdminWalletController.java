package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.repositories.WalletRepository;
import com.agile.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.*;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_URI_PARAM;
import static com.agile.resources.UriPaths.ADMIN_WALLETS_URI;

@Controller
public class AdminWalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private WebAppConfigHandler webConfHandler;

    private static final String WALLETS_DATA= "wallets";

    @GetMapping(value = ADMIN_WALLETS_URI)
    public ModelAndView loadWallets() {
        ModelAndView modelAndView = getModelAndView("wallets");
        modelAndView.addObject(WALLETS_DATA, walletService.fetchWallets());
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
