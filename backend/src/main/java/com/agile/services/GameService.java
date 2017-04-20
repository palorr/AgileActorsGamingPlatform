package com.agile.services;

import com.agile.model.Game;
import com.agile.model.OperationEnum;
import com.agile.model.User;
import com.agile.model.Wallet;
import com.agile.repositories.GameRepository;
import com.agile.resources.GameResource;
import com.agile.resources.GameResourceAfterPlay;
import com.agile.resources.GameResourceToPlay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Archontellis on 13/4/2017.
 */
@Service("gameService")
public class GameService {

	private GameRepository gameRepository;
	private UserService userService;
	private WalletService walletService;
	private OperationsService operationsService;

	@Autowired
	public GameService(GameRepository gameRepository, UserService userService,
			WalletService walletService, OperationsService operationsService) {
		this.gameRepository = gameRepository;
		this.userService = userService;
		this.walletService = walletService;
		this.operationsService = operationsService;
	}

	@Transactional
	public void saveGame(Game game) {
		gameRepository.save(game);
	}

	@Transactional
	public List<GameResource> getBasicInfoOfAllGames() {
		List<GameResource> gamesToReturn = gameRepository.findAll().stream().map(game -> {
			
			GameResource resource = new GameResource();
			resource.setId(game.getId());
			resource.setName(game.getName());
			resource.setDescription(game.getDescription());
			resource.setAvatar(game.getAvatar());
			resource.setWinCredits(game.getWin_credits());
			resource.setBuyCredits(game.getBuy_credits());
			
			return resource;
			
		}).collect(Collectors.toList());

		return gamesToReturn;
	}

	@Transactional
	public List<GameResource> getBasicInfoOfAllGamesWithNameStartsWith(String searchTerm){

		List<GameResource> gamesWithSearchCriteria = gameRepository.findByNameStartingWith(searchTerm).stream().map(game ->{

			GameResource resource = new GameResource();
			resource.setId(game.getId());
			resource.setBuyCredits(game.getBuy_credits());
			resource.setWinCredits(game.getWin_credits());
			resource.setName(game.getName());
			resource.setDescription(game.getDescription());
			resource.setAvatar(game.getAvatar());
			return resource;

		}).collect(Collectors.toList());
		return gamesWithSearchCriteria;
	}

	@Transactional
	public GameResource getGameBasicInfoById(int id) {
		Game game = gameRepository.findById(id);
		GameResource resource = new GameResource();
		resource.setId(id);
		resource.setName(game.getName());
		resource.setDescription(game.getDescription());
		resource.setAvatar(game.getAvatar());
		resource.setWinCredits(game.getWin_credits());
		resource.setBuyCredits(game.getBuy_credits());
		
		return resource;
	}

	public Game findGameById(int id) {
		return gameRepository.findById(id);
	}

	/**
	 * this service finds the user, wallet, and game 
	 * if wallet is ok to play the service continues
	 * 
	 * 
	 * @param resource containing the required parameters
	 * @return
	 */
	@Transactional
	public GameResourceAfterPlay playGame(GameResourceToPlay resource) {
		boolean win;
		boolean enoughCredits;
		int amount;
		int credits;
		
		Double number = Math.random(); // random double between 0 & 1

		User user = userService.findUserById(resource.getUserId());
		Wallet wallet = walletService.findWalletById(user.getWallet().getId());
		Game gameToPlay = findGameById(resource.getGameId());

		if (wallet.getCredits() > gameToPlay.getBuy_credits()) {
			enoughCredits = true;
			Wallet walletToUpdate = new Wallet();
			
			if (number <= gameToPlay.getYield()) { // the user wins when the number is below the yield
				win = true;
				amount = gameToPlay.getWin_credits();
				credits = wallet.getCredits() + gameToPlay.getWin_credits();
				
				walletToUpdate.setId(wallet.getId());
				walletToUpdate.setCredits(credits);
				walletService.updateWalletCredits(walletToUpdate); // update the wallet by remove or add credits
				
				operationsService.PlayOperations(user, gameToPlay.getWin_credits(), gameToPlay, win, OperationEnum.ADDED, false); // look into for more details

			} else { // or loses if is over the yield
				win = false;
				amount = 0;
				credits = wallet.getCredits() - gameToPlay.getWin_credits();
				
				walletToUpdate.setId(wallet.getId());
				walletToUpdate.setCredits(credits);
				walletService.updateWalletCredits(walletToUpdate); // update the wallet by remove or add credits
				
				operationsService.PlayOperations(user, gameToPlay.getWin_credits(), gameToPlay, win, OperationEnum.REMOVED, false); // look into for more details
			}

		} else {
			enoughCredits = false;
			win = false;
			amount = 0;
		}
		return new GameResourceAfterPlay(win, enoughCredits, amount);
	}

}
