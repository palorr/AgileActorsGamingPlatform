package com.agile;

import com.agile.model.*;
import com.agile.model.enums.OperationEnum;
import com.agile.repositories.*;
import com.agile.services.api.UserServiceInterface;
import com.agile.resources.UserSaveData;
import com.agile.services.api.GameServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;

@SpringBootApplication
public class AgileTwoApplication 
implements CommandLineRunner 
{
	public static void main(String[] args) {
		SpringApplication.run(AgileTwoApplication.class, args);
	}
	
	@Autowired
	private TryRepository tryRepository;

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
		Wallet wallet4 = new Wallet(6000);

		walletRepository.save(wallet1);
		walletRepository.save(wallet2);
		walletRepository.save(wallet3);
        walletRepository.save(wallet4);
        
        Tries tries = new Tries();
        tryRepository.save(tries);


		User user1 = new User("Archontellis", "Sotirchellis",
				"user1", "agiletest", userRole, wallet1);
		user1.setAvatar("https://media.licdn.com/mpr/mpr/shrinknp_200_200/AAEAAQAAAAAAAATNAAAAJDdjYmM0NmI0LTViNDMtNDE0Ny04Mjk2LTkzZDI2MmM2MjU3Zg.jpg");
		UserSaveData userData1 = new UserSaveData(user1);

		User user2 = new User("Nikos", "Mastrogiannopoulos",
				"user2", "agiletest", userRole, wallet2);
		user2.setAvatar("https://scontent.fath3-2.fna.fbcdn.net/v/t1.0-9/15826725_10209595825591327_3694477759808677138_n.jpg?oh=ac322b5ce4eb225c856d7953c7c1609c&oe=598E674D");
		UserSaveData userData2 = new UserSaveData(user2);

		User user3 = new User("Stamatis", "Katsaounis",
				"user3", "agiletest", userRole, wallet3);
		UserSaveData userData3 = new UserSaveData(user3);

		User user4 = new User("Vlasis", "Barousis",
				"user4", "agiletest", userRole, wallet4);
		user4.setAvatar("https://scontent.fath3-2.fna.fbcdn.net/v/t1.0-9/9157_10207996918935306_4375061747766220940_n.jpg?oh=9b94a4a84d3dd84cbede66df1d5ae9a3&oe=5998A84F");
		UserSaveData userData4 = new UserSaveData(user4);

		User admin1 = new User("adminNameOne", "adminSurnameOne",
				"admin1", "adminpass1", adminRole, null);
		UserSaveData userAdmin1 = new UserSaveData(admin1);

		userService.createUser(userData1);
		userService.createUser(userData2);
		userService.createUser(userData3);
		userService.createUser(userData4);
		userService.createUser(userAdmin1);


		Game game1 = new Game(10, 50, "Roullete", "game 1 description","",0.3);
		Game game2 = new Game(40, 100, "BlackJack", "game 2 description","",0.5);

		game1.setAvatar("https://68.media.tumblr.com/8220060b6e6c9c2cca312641277e3f12/tumblr_njz885ZeDA1s2wio8o1_500.gif");
		game2.setAvatar("https://68.media.tumblr.com/78bd456f44ab059cda364aed9812a2f4/tumblr_o1m115Z1Zr1s2wio8o1_500.gif");

		game1.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
		game2.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
		gameRepository.save(game1);
		gameRepository.save(game2);

		UpdatedGames updatedGame1 = new UpdatedGames(game1, userService.getUserByUsername("user1"), transactionTime);
		UpdatedGames updatedGame2 = new UpdatedGames(game2, userService.getUserByUsername("user2"), transactionTime);
		UpdatedGames updatedGame3 = new UpdatedGames(game2, userService.getUserByUsername("user3"), transactionTime);

		updatedGamesRepository.save(updatedGame1);
		updatedGamesRepository.save(updatedGame2);
		updatedGamesRepository.save(updatedGame3);

		UserCreditsOperation userCreditsOperation1 = new UserCreditsOperation(userService.getUserByUsername("user1"), 400,
				OperationEnum.ADDED, transactionTime);
		UserCreditsOperation userCreditsOperation2 = new UserCreditsOperation(userService.getUserByUsername("user1"), 200,
				OperationEnum.REMOVED, transactionTime);
		UserCreditsOperation userCreditsOperation3 = new UserCreditsOperation(userService.getUserByUsername("user2"), 124,
				OperationEnum.ADDED, transactionTime);


		userCreditsOperationsRepository.save(userCreditsOperation1);
		userCreditsOperationsRepository.save(userCreditsOperation2);
		userCreditsOperationsRepository.save(userCreditsOperation3);

		UserGameBuyOperation userGameBuyOperation1 = new UserGameBuyOperation(userService.getUserByUsername("user1"), game1, transactionTime);
		UserGameBuyOperation userGameBuyOperation2 = new UserGameBuyOperation(userService.getUserByUsername("user1"), game2, transactionTime);
		UserGameBuyOperation userGameBuyOperation3 = new UserGameBuyOperation(userService.getUserByUsername("user3"), game2, transactionTime);

		userGameBuyOperationRepository.save(userGameBuyOperation1);
		userGameBuyOperationRepository.save(userGameBuyOperation2);
		userGameBuyOperationRepository.save(userGameBuyOperation3);

		UserGamePlayOperation userGamePlayOperation1 = new UserGamePlayOperation(userService.getUserByUsername("user1"), game1, 500,
				false, true, transactionTime);
		UserGamePlayOperation userGamePlayOperation2  = new UserGamePlayOperation(userService.getUserByUsername("user1"), game2, 0,
				false, false, transactionTime);

		userGamePlayOperationRepository.save(userGamePlayOperation1);
		userGamePlayOperationRepository.save(userGamePlayOperation2);

		AdminViewOperation viewOperation1 = new AdminViewOperation(userService.getUserByUsername("user1"), transactionTime );
		AdminViewOperation viewOperation2 = new AdminViewOperation(userService.getUserByUsername("user2"), transactionTime );
		AdminViewOperation viewOperation3 = new AdminViewOperation(userService.getUserByUsername("user3"), transactionTime );
		AdminViewOperation viewOperation4 = new AdminViewOperation(userService.getUserByUsername("user2"), transactionTime );

		adminViewOperationRepository.save(viewOperation1);
		adminViewOperationRepository.save(viewOperation2);
		adminViewOperationRepository.save(viewOperation3);
		adminViewOperationRepository.save(viewOperation4);
	}
}
