package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.services.api.GameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.*;
import static com.agile.resources.UriPaths.ADMIN_GAMES_ID_URI;
import static com.agile.resources.UriPaths.ADMIN_GAMES_URI;

@Controller
public class AdminGameController {

    @Autowired
    private GameServiceInterface gameService;

    @Autowired
    private WebAppConfigHandler webConfHandler;

    private static final String GAMES_DATA= "games";
    private static final String GAME_DATA= "game";

    @GetMapping(value = ADMIN_GAMES_URI)
    public ModelAndView loadGames() {
        ModelAndView modelAndView = getModelAndView("games");
        modelAndView.addObject(ADMIN_UPDATE_GAME_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_UPDATE_GAME_URI_PARAM));
        modelAndView.addObject(ADMIN_DELETE_GAME_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_DELETE_GAME_URI_PARAM));
        modelAndView.addObject(GAMES_DATA, gameService.fetchGames());
        return modelAndView;
    }

    @GetMapping(value = ADMIN_GAMES_ID_URI)
    public ModelAndView loadGameDetails(@PathVariable(value="id") Integer id) {
        ModelAndView modelAndView = getModelAndView("game_details");
        modelAndView.addObject(GAME_DATA, gameService.getGame(id));
        modelAndView.addObject(ADMIN_GAMES_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_GAMES_URI_PARAM));
        return modelAndView;
    }

    private ModelAndView getModelAndView(String viewName) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(LOGOUT_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(LOGOUT_URI_PARAM));
        modelAndView.addObject(ADMIN_GAMES_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_GAMES_URI_PARAM));
        return modelAndView;
    }
}
