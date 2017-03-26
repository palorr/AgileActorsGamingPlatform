package com.agile.controllers;

import com.agile.models.Game;
import com.agile.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    private static final String GAMES_DATA= "games";
    private static final String GAME_DATA= "game";

    @RequestMapping(value = "/admin/games", method = RequestMethod.GET)
    public String games(ModelMap model) {
        Iterable<Game> games = gameRepository.findAll();
        model.addAttribute(GAMES_DATA, games);
        return "games";
    }

    @RequestMapping(value = "/admin/games/{id}", method = RequestMethod.GET)
    public String game_details(@PathVariable(value="id") Integer id, ModelMap model) {
        Game game = gameRepository.findOne(id);
        model.addAttribute(GAME_DATA, game);
        return "game_details";
    }
}
