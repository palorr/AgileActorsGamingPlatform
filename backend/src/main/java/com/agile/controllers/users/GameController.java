package com.agile.controllers.users;

import java.util.List;
import com.agile.services.api.GameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.agile.resources.GameResource;
import com.agile.resources.GameResourceAfterPlay;
import com.agile.resources.GameResourceAfterTry;
import com.agile.resources.GameResourceToPlayOrTry;

@CrossOrigin(origins = "http://localhost:5555")
@RestController
public class GameController {

	@Autowired
	private GameServiceInterface gameService;

	@GetMapping(value = "games")
	public List<GameResource> getBasicInfoOfAllGames() {
		return gameService.getBasicInfoOfAllGames();
	}

	@GetMapping(value = "games/{id}")
	public GameResource getGameBasicInfoById(@PathVariable(value = "id") int id) {
		return gameService.getGameBasicInfoById(id);
	}

	@PostMapping(value = "games/play")
	public GameResourceAfterPlay selectGameToPlay(@RequestBody GameResourceToPlayOrTry resource) {
		return gameService.playGame(resource);
	}
	
	@PostMapping(value = "games/try")
	public GameResourceAfterTry selectGameToTry(@RequestBody GameResourceToPlayOrTry resource) {
		return gameService.tryGame(resource);
	}

	@GetMapping(value = "/games/search/{searchTerm}")
	public List<GameResource> searchUser(@PathVariable(value = "searchTerm") String searchTerm){
		return gameService.getBasicInfoOfAllGamesWithNameStartsWith(searchTerm);
	}
}
