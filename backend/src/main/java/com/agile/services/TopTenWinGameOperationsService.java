package com.agile.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.agile.model.Game;
import com.agile.model.User;
import com.agile.repositories.CountGame;
import com.agile.repositories.GameRepository;
import com.agile.repositories.UserGamePlayOperationRepository;
import com.agile.resources.GameResource;
import com.agile.resources.WinGamesResource;

@Service
public class TopTenWinGameOperationsService {

	@Autowired
	private UserGamePlayOperationRepository userGameOperationRepository;

	@Autowired
	private GameRepository gameRepository;

	public List<WinGamesResource> getWinGames() {

		return userGameOperationRepository.findTop10ByIsWinOrderByDateDesc(true).stream().map(operation -> {
			User user = operation.getUser();
			Game game = operation.getGame();

			WinGamesResource resource = new WinGamesResource();
			resource.setUsername(user.getUsername());
			resource.setGameName(game.getName());
			resource.setDate(operation.getDate());
			resource.setCreditsWon(operation.getWinCredits());

			return resource;

		}).collect(Collectors.toList());
	}

	public List<GameResource> getMostTrendingGames() {
		List<CountGame> counts = userGameOperationRepository.findGames(new PageRequest(0, 2));
		List<Integer> ids = counts.stream().map(CountGame::getId).collect(Collectors.toList());

		return gameRepository.findByIdIn(ids).stream().map(this::convertToGameResource).collect(Collectors.toList());
	}

	private GameResource convertToGameResource(Game game) {
		GameResource resource = new GameResource();
		resource.setId(game.getId());
		resource.setName(game.getName());
		resource.setAvatar(game.getAvatar());
		resource.setDescription(game.getDescription());
		resource.setBuyCredits(game.getBuy_credits());
		resource.setWinCredits(game.getWin_credits());

		return resource;
	}
}
