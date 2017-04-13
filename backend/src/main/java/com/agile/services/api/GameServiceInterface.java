package com.agile.services.api;

import com.agile.model.Game;

import java.util.List;
import java.util.Map;

/**
 * Created by Archontellis on 13/4/2017.
 */
public interface GameServiceInterface {

    void saveGame(Game game) ;

    List<Map<String, Object>> getBasicInfoOfAllGames();

    Map<String, Object> getGameBasicInfoById(int id);

}
