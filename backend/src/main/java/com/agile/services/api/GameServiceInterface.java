package com.agile.services.api;

import com.agile.model.Game;
import com.agile.resources.GameResource;
import com.agile.resources.GameResourceAfterPlay;
import com.agile.resources.GameResourceAfterTry;
import com.agile.resources.GameResourceToPlayOrTry;

import java.util.List;

public interface GameServiceInterface {

    void saveGame(Game game);
    List<Game> fetchGames();
    void deleteGame(int id);
    Game getGame(int id);
    Game updateGameByAdmin(Game game);
    List<GameResource> getBasicInfoOfAllGames();
    List<GameResource> getBasicInfoOfAllGamesWithNameStartsWith(String searchTerm);
    GameResource getGameBasicInfoById(int id);
    GameResourceAfterPlay playGame(GameResourceToPlayOrTry resource);
    GameResourceAfterTry tryGame(GameResourceToPlayOrTry resource);
}
