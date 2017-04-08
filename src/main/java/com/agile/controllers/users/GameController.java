package com.agile.controllers.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.agile.model.Game;
import com.agile.repositories.GameRepository;

@RestController
public class GameController {

	@Autowired
	private GameRepository gameRepository;

	@GetMapping(value = "user/games")
	public List<Game> games() {
		List<Game> games = gameRepository.findAll();
		return games;
	}

	@GetMapping(value = "user/games/{id}")
	public Game gameDetails(@PathVariable(value = "id") Integer id) {
		Game game = gameRepository.findOne(id);
		return game;
	}

	@GetMapping(value = "user/game")
	public Game gameDetailsByName(@Param(value = "name") String name) {
		Game game = gameRepository.findByName(name);
		return game;
	}

}
