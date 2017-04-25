package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.model.Game;
import com.agile.services.api.GameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.*;
import static com.agile.resources.UriPaths.*;

@Controller
public class GameFormController {

    @Autowired
    private WebAppConfigHandler webConfHandler;

    @Autowired
    private GameServiceInterface gameService;

    @RequestMapping(value = ADMIN_DELETE_GAME_ID_URI)
    public ModelAndView delete(@PathVariable(value="id") Integer id) {
        gameService.deleteGame(id);
        return getModelAndView(REDIRECT_ADMIN_GAMES_URI);
    }

    @GetMapping(value = ADMIN_CREATE_GAME_URI)
    public ModelAndView create() {
        ModelAndView modelAndView = getModelAndView("game_form");
        modelAndView.addObject("url", ADMIN_CREATE_GAME_URI);
        return modelAndView;
    }

    @PostMapping(value = ADMIN_CREATE_GAME_URI)
    public ModelAndView save(@ModelAttribute("game") Game game) {
        gameService.saveGame(game);
        return getModelAndView(REDIRECT_ADMIN_GAMES_URI);
    }

    @GetMapping(value = ADMIN_UPDATE_GAME_ID_URI)
    public ModelAndView edit(@PathVariable(value="id") Integer id, Model model) {
        Game game = gameService.getGame(id);
        ModelAndView modelAndView = getModelAndView("game_form");
        modelAndView.addObject("game", game);
        model.addAttribute("url", webConfHandler.getWebAppPath(ADMIN_UPDATE_GAME_URI_PARAM));
        return modelAndView;
    }

    @PostMapping(value = ADMIN_UPDATE_GAME_URI)
    public ModelAndView change(@ModelAttribute("game") Game game) {
        gameService.saveGame(game);
        return getModelAndView(REDIRECT_ADMIN_GAMES_URI);
    }

    private ModelAndView getModelAndView(String viewName) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(ADMIN_UPDATE_GAME_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_UPDATE_GAME_URI_PARAM));
        modelAndView.addObject(ADMIN_GAMES_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_GAMES_URI_PARAM));
        modelAndView.addObject(LOGOUT_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(LOGOUT_URI_PARAM));
        return modelAndView;
    }
}
