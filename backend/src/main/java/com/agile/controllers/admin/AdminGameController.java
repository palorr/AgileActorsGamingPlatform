package com.agile.controllers.admin;

import com.agile.model.Game;
import com.agile.services.api.GameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class AdminGameController {
    @Autowired
    private GameServiceInterface gameService;

    private static final String GAMES_DATA= "games";
    private static final String GAME_DATA= "game";

    @GetMapping(value = "/admin/games")
    public String games(ModelMap model) {
        List<Game> games = gameService.fetchGames();
        model.addAttribute(GAMES_DATA, games);
        return "games";
    }

    @GetMapping(value = "/admin/games/{id}")
    public String game_details(@PathVariable(value="id") Integer id, ModelMap model) {
        Game game = gameService.getGame(id);
        model.addAttribute(GAME_DATA, game);
        return "game_details";
    }
}
