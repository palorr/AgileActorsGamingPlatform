package com.agile.controllers.users;

import java.util.List;
import java.util.Map;

import com.agile.services.api.GameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.agile.model.Game;
import com.agile.repositories.GameRepository;

@CrossOrigin(origins = "http://localhost:5555")
@RestController
public class GameController {

	@Autowired
	private GameServiceInterface gameService;

	@GetMapping(value = "games")
	public List<Map<String, Object>> getBasicInfoOfAllGames() {
		List<Map<String, Object>> games = gameService.getBasicInfoOfAllGames();
		return games;
	}

	@GetMapping(value = "games/{id}")
	public Map<String, Object> getGameBasicInfoById(@PathVariable(value = "id") int id) {
		return gameService.getGameBasicInfoById(id);
	}

}
