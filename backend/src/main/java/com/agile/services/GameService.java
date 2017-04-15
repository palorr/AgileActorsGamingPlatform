package com.agile.services;

import com.agile.model.Game;
import com.agile.model.User;
import com.agile.model.UserCreditsOperation.OperationEnum;
import com.agile.model.Wallet;
import com.agile.repositories.GameRepository;
import com.agile.resources.GameResource;
import com.agile.resources.GetGameResource;

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
	public List<Map<String, Object>> getBasicInfoOfAllGames() {

		Map<String, Object> map;
		List<Game> games = gameRepository.findAll();
		List<Map<String, Object>> gamesToReturn = new ArrayList<>();

		for (Game game : games) {

			map = new HashMap<>();

			map.put("id", game.getId());
			map.put("name", game.getName());
			map.put("description", game.getDescription());
			map.put("avatar", game.getAvatar());
			map.put("buy_credits", game.getBuy_credits());
			map.put("win_credits", game.getWin_credits());

			gamesToReturn.add(map);
		}

		return gamesToReturn;
	}

	@Transactional
	public Map<String, Object> getGameBasicInfoById(int id) {
		Game game = gameRepository.findById(id);
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("id", game.getId());
		map.put("name", game.getName());
		map.put("description", game.getDescription());
		map.put("avatar", game.getAvatar());
		map.put("buy_credits", game.getBuy_credits());
		map.put("win_credits", game.getWin_credits());
		return map;
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
	public GameResource playGame(GetGameResource resource) {
		boolean win;
		boolean enoughCredits;
		int ammount;
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
				ammount = gameToPlay.getWin_credits();
				credits = wallet.getCredits() + gameToPlay.getWin_credits();
				
				walletToUpdate.setId(wallet.getId());
				walletToUpdate.setCredits(credits);
				walletService.updateWalletCredits(walletToUpdate); // update the wallet by remove or add credits
				
				operationsService.PlayOperations(user, gameToPlay.getWin_credits(), gameToPlay, win, OperationEnum.ADDED, false); // look into for more details

			} else { // or loses if is over the yield
				win = false;
				ammount = 0;
				credits = wallet.getCredits() - gameToPlay.getWin_credits();
				
				walletToUpdate.setId(wallet.getId());
				walletToUpdate.setCredits(credits);
				walletService.updateWalletCredits(walletToUpdate); // update the wallet by remove or add credits
				
				operationsService.PlayOperations(user, gameToPlay.getWin_credits(), gameToPlay, win, OperationEnum.REMOVED, false); // look into for more details
			}

		} else {
			enoughCredits = false;
			win = false;
			ammount = 0;
		}
		return new GameResource(win, enoughCredits, ammount); 
	}

}
