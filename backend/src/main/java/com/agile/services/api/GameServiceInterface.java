package com.agile.services.api;

import com.agile.model.Game;

import java.util.List;

public interface GameServiceInterface {

    void saveGame(Game game);
    List<Game> fetchGames();
    void deleteGame(int id);
    Game getGame(int id);
    Game updateGameByAdmin(Game game);
}
