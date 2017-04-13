package com.agile.services;

import com.agile.model.Game;
import com.agile.repositories.GameRepository;
import com.agile.services.api.GameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Archontellis on 13/4/2017.
 */
@Service("gameService")
public class GameService implements GameServiceInterface {

    @Autowired
    private GameRepository gameRepo ;

    @Override
    @Transactional
    public void saveGame(Game game){
        gameRepo.save(game);
    }

    @Override
    @Transactional
    public List<Map<String, Object>> getBasicInfoOfAllGames(){

        Map<String , Object> map ;
        List<Game> games =  gameRepo.findAll();
        List<Map<String , Object>> gamesToReturn = new ArrayList<>();

        for( Game game : games){

            map= new HashMap<>();

            map.put("id",game.getId());
            map.put("name",game.getName());
            map.put("description",game.getDescription());
            map.put("buy_credits",game.getBuy_credits());
            map.put("win_credits",game.getWin_credits());

            gamesToReturn.add(map);
        }

        return gamesToReturn ;
    }

    @Override
    @Transactional
    public Map<String, Object> getGameBasicInfoById(int id){
        Game game = gameRepo.findById(id) ;
        Map<String , Object> map = new HashMap<String, Object>();

        map.put("id",game.getId());
        map.put("name",game.getName());
        map.put("description",game.getDescription());
        map.put("buy_credits",game.getBuy_credits());
        map.put("win_credits",game.getWin_credits());
        return map ;
    }
}
