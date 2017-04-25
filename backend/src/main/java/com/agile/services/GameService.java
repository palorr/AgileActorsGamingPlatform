package com.agile.services;

import com.agile.model.Game;
import com.agile.model.Tries;
import com.agile.model.User;
import com.agile.model.Wallet;
import com.agile.model.enums.OperationEnum;
import com.agile.repositories.GameRepository;
import com.agile.repositories.TryRepository;
import com.agile.resources.GameResource;
import com.agile.resources.GameResourceAfterPlay;
import com.agile.resources.GameResourceAfterTry;
import com.agile.resources.GameResourceToPlayOrTry;
import com.agile.services.api.GameServiceInterface;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("gameService")
public class GameService implements GameServiceInterface{

    @Autowired
	private OperationsService operationsService;

	@Autowired
	private WalletService walletService;

	@Autowired
	private UserServiceInterface userService;

	@Autowired
    private TryRepository tryRepository;

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
	public GameResourceAfterPlay playGame(GameResourceToPlayOrTry resource) {
		boolean win;
		boolean enoughCredits;
		int amount;
		int credits;

		Double number = Math.random(); // random double between 0 & 1

		User user = userService.findUserById(resource.getUserId());
		Wallet wallet = walletService.findWalletById(user.getWallet().getId());
		Game gameToPlay = findGameById(resource.getGameId());

		if (wallet.getCredits() > gameToPlay.getBuy_credits()) { // if has enough credits
			enoughCredits = true;
			Wallet walletToUpdate = new Wallet();

			if (number <= gameToPlay.getYield()) { // the user wins when the number is below the yield
				win = true;
				amount = gameToPlay.getWin_credits();
				credits = wallet.getCredits() + gameToPlay.getWin_credits() - gameToPlay.getBuy_credits();

				walletToUpdate.setId(wallet.getId());
				walletToUpdate.setCredits(credits);
				walletService.updateWalletCredits(walletToUpdate); // update the wallet by remove or add credits

				operationsService.PlayOperations(user, gameToPlay.getWin_credits(), gameToPlay, win, OperationEnum.ADDED, false); // look into for more details

			} else { // or loses if is over the yield
				win = false;
				amount = 0;
				credits = wallet.getCredits() - gameToPlay.getBuy_credits(); // only lose the money

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

	@Transactional
	public GameResourceAfterTry tryGame(GameResourceToPlayOrTry resource) {
		boolean win;
		boolean enoughTries;

		Double number = Math.random(); // random double between 0 & 1
		Game gameToPlay = findGameById(resource.getGameId());

		if (tryRepository.findByGameIdAndUserId(resource.getGameId(), resource.getUserId()) == null){
			Tries tries = new Tries();
			tries.setGameId(resource.getGameId());
			tries.setUserId(resource.getUserId());
			tries.setTryNum(0);
			tryRepository.save(tries);
		}

		Tries efforts = tryRepository.findByGameIdAndUserId(resource.getGameId(), resource.getUserId());
		int tr = efforts.getTryNum();

		if (tr < 3){
			if (number <= gameToPlay.getYield()) { // the user wins when the number is below the yield
				win = true;
			}
			else { // or loses if is over the yield
				win = false;
			}

			tr += 1;
			efforts.setTryNum(tr);
			tryRepository.save(efforts);

			return new GameResourceAfterTry( win , tr);
		}
		return new GameResourceAfterTry(false, 0);
	}
}
