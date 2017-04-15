package com.agile.controllers.users;

import java.util.List;
import java.util.Map;
import com.agile.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agile.resources.GameResource;
import com.agile.resources.GetGameResource;

//@CrossOrigin(origins = "http://localhost:5555")
@RestController
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping(value = "games")
	public List<Map<String, Object>> getBasicInfoOfAllGames() {
		List<Map<String, Object>> games = gameService.getBasicInfoOfAllGames();
		return games;
	}

	@GetMapping(value = "games/{id}")
	public Map<String, Object> getGameBasicInfoById(@PathVariable(value = "id") int id) {
		return gameService.getGameBasicInfoById(id);
	}

	@PostMapping(value = "games/play")
	public GameResource selectGameToPlay(@RequestBody GetGameResource resource) {
		return gameService.playGame(resource);
	}

}
