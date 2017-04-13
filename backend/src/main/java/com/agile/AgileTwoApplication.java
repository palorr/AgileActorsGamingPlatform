package com.agile;

import com.agile.model.*;
import com.agile.repositories.*;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class AgileTwoApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(AgileTwoApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private UpdatedGamesRepository updatedGamesRepository;

	@Autowired
	private UserCreditsOperationsRepository userCreditsOperationsRepository;

	@Autowired
	private UserGameBuyOperationRepository userGameBuyOperationRepository;

	@Autowired
	private UserGamePlayOperationRepository userGamePlayOperationRepository;

	@Autowired
	private AdminViewOperationRepository adminViewOperationRepository;

	@Autowired
	private WalletRepository walletRepository;

	@Autowired
	private UserServiceInterface userService;

	@Override
	public void run(String... strings) throws Exception {

		Timestamp transactionTime = new Timestamp(System.currentTimeMillis());

		System.out.println("Spring Application started.:");

		Role adminRole = new Role("ADMIN");
		Role userRole = new Role("USER");

		roleRepository.save(adminRole);
		roleRepository.save(userRole);

		Wallet wallet1 = new Wallet(5000);
		Wallet wallet2 = new Wallet(3000);
		Wallet wallet3 = new Wallet(2000);

		walletRepository.save(wallet1);
		walletRepository.save(wallet2);
		walletRepository.save(wallet3);


		User user1 = new User("userName1", "userSurname1",
				"user1", "userpass1", userRole, wallet1);

		User user2 = new User("userName2", "userSurname2",
				"user2", "userpass2", userRole, wallet2);

		User user3 = new User("userName3", "userSurname3",
				"user3", "userpass3", userRole, wallet3);

		User admin1 = new User("adminName1", "adminSurname1",
				"admin1", "adminpass1", adminRole, null);


		userService.saveUser(user1);
		userService.saveUser(user2);
		userService.saveUser(user3);
		userService.saveUser(admin1);


		Game game1 = new Game(10, 100, "game1Name", "game 1 description");
		Game game2 = new Game(40, 450, "game2Name", "game 2 description");

		gameRepository.save(game1);
		gameRepository.save(game2);

		UpdatedGames updatedGame1 = new UpdatedGames(game1, user2, transactionTime);
		UpdatedGames updatedGame2 = new UpdatedGames(game2, user2, transactionTime);
		UpdatedGames updatedGame3 = new UpdatedGames(game2, user3, transactionTime);

		updatedGamesRepository.save(updatedGame1);
		updatedGamesRepository.save(updatedGame2);
		updatedGamesRepository.save(updatedGame3);

		UserCreditsOperation userCreditsOperation1 = new UserCreditsOperation(user1, 400,
				UserCreditsOperation.OperationEnum.ADDED, transactionTime);
		UserCreditsOperation userCreditsOperation2 = new UserCreditsOperation(user1, 200,
				UserCreditsOperation.OperationEnum.REMOVED, transactionTime);
		UserCreditsOperation userCreditsOperation3 = new UserCreditsOperation(user2, 124,
				UserCreditsOperation.OperationEnum.ADDED, transactionTime);


		userCreditsOperationsRepository.save(userCreditsOperation1);
		userCreditsOperationsRepository.save(userCreditsOperation2);
		userCreditsOperationsRepository.save(userCreditsOperation3);

		UserGameBuyOperation userGameBuyOperation1 = new UserGameBuyOperation(user1, game1, transactionTime);
		UserGameBuyOperation userGameBuyOperation2 = new UserGameBuyOperation(user1, game2, transactionTime);
		UserGameBuyOperation userGameBuyOperation3 = new UserGameBuyOperation(user3, game2, transactionTime);

		userGameBuyOperationRepository.save(userGameBuyOperation1);
		userGameBuyOperationRepository.save(userGameBuyOperation2);
		userGameBuyOperationRepository.save(userGameBuyOperation3);

		UserGamePlayOperation userGamePlayOperation1 = new UserGamePlayOperation(user1, game1, 500,
				false, true, transactionTime);
		UserGamePlayOperation userGamePlayOperation2  = new UserGamePlayOperation(user1, game2, 0,
				false, false, transactionTime);

		userGamePlayOperationRepository.save(userGamePlayOperation1);
		userGamePlayOperationRepository.save(userGamePlayOperation2);

		AdminViewOperation viewOperation1 = new AdminViewOperation(user1, transactionTime );
		AdminViewOperation viewOperation2 = new AdminViewOperation(user2, transactionTime );
		AdminViewOperation viewOperation3 = new AdminViewOperation(user3, transactionTime );
		AdminViewOperation viewOperation4 = new AdminViewOperation(user2, transactionTime );

		adminViewOperationRepository.save(viewOperation1);
		adminViewOperationRepository.save(viewOperation2);
		adminViewOperationRepository.save(viewOperation3);
		adminViewOperationRepository.save(viewOperation4);
	}
}