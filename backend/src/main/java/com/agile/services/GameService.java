package com.agile.services;

import com.agile.model.Game;
import com.agile.repositories.GameRepository;
import com.agile.services.api.GameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("gameService")
public class GameService implements GameServiceInterface{

    @Autowired
    private GameRepository gameRepository;

    @Override
    @Transactional
    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    @Override
    @Transactional
    public List<Game> fetchGames() {
        return gameRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteGame(int id){
        gameRepository.delete(id);
    }

    @Override
    @Transactional
    public Game getGame(int id){
        return gameRepository.findOne(id);
    }
}
