package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import static com.agile.handlers.UriPaths.ADMIN_GAMES_ID_URI;
import static com.agile.handlers.UriPaths.ADMIN_GAMES_URI;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_GAMES_URI_PARAM;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_USERS_URI_PARAM;

@Controller
public class AdminGameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private WebAppConfigHandler webAppConfigHandler;

    private static final String GAMES_DATA= "games";
    private static final String GAME_DATA= "game";

    @GetMapping(value = ADMIN_GAMES_URI)
    public ModelAndView loadGames() {
        return new ModelAndView("games",
                GAMES_DATA, gameRepository.findAll());
    }

    @GetMapping(value = ADMIN_GAMES_ID_URI)
    public ModelAndView loadGameDetails(@PathVariable(value="id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("game_details");
        modelAndView.addObject(GAME_DATA, gameRepository.findOne(id));
        modelAndView.addObject(ADMIN_GAMES_URI_PARAM.getWebConfigParam(),
                webAppConfigHandler.getWebAppPath(ADMIN_GAMES_URI_PARAM));
        return modelAndView;
    }
}
