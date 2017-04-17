package com.agile.controllers.users;

import java.util.List;
import com.agile.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.agile.resources.GameResource;
import com.agile.resources.GameResourceAfterPlay;
import com.agile.resources.GameResourceToPlay;

@CrossOrigin(origins = "http://localhost:5555")
@RestController
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping(value = "games")
	public List<GameResource> getBasicInfoOfAllGames() {
		return gameService.getBasicInfoOfAllGames();
	}

	@GetMapping(value = "games/{id}")
	public GameResource getGameBasicInfoById(@PathVariable(value = "id") int id) {
		return gameService.getGameBasicInfoById(id);
	}

	@PostMapping(value = "games/play")
	public GameResourceAfterPlay selectGameToPlay(@RequestBody GameResourceToPlay resource) {
		return gameService.playGame(resource);
	}

}
