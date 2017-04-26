package com.agile.services;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.model.Game;
import com.agile.model.User;
import com.agile.model.UserCreditsOperation;
import com.agile.model.UserGameBuyOperation;
import com.agile.model.UserGamePlayOperation;
import com.agile.model.enums.OperationEnum;
import com.agile.repositories.UserCreditsOperationsRepository;
import com.agile.repositories.UserGameBuyOperationRepository;
import com.agile.repositories.UserGamePlayOperationRepository;

/**
 * service that updates the userGamePlayOperation, UserGameBuyOperation & userCreditsOperation tables
 * 
 * @author NikosMas
 *
 */
@Service
public class OperationsService {

	private UserCreditsOperationsRepository userCreditsOperationsRepository;
	private UserGameBuyOperationRepository userGameBuyOperationRepository;
	private UserGamePlayOperationRepository userGamePlayOperationRepository;

	@Autowired
	public OperationsService(UserCreditsOperationsRepository userCreditsOperationsRepository,
			UserGameBuyOperationRepository userGameBuyOperationRepository,
			UserGamePlayOperationRepository userGamePlayOperationRepository) {

		this.userCreditsOperationsRepository = userCreditsOperationsRepository;
		this.userGameBuyOperationRepository = userGameBuyOperationRepository;
		this.userGamePlayOperationRepository = userGamePlayOperationRepository;
	}

	/**
	 * @param user
	 * @param credits -> credits added or removed
	 * @param game
	 * @param win -> win or not
	 * @param operation -> ADDED or REMOVED credits
	 * @param isTry -> play or try the game
	 */
	@Transactional
	public void PlayOperations(User user, int credits, Game game, boolean win, OperationEnum operation, boolean isTry) {

		Timestamp date = new Timestamp(System.currentTimeMillis()); // get current date and time

		UserCreditsOperation creditsOperation = new UserCreditsOperation(user, credits, operation, date);
		userCreditsOperationsRepository.save(creditsOperation);

		if (win == true && isTry == false) {
			UserGamePlayOperation userPlayOperation = new UserGamePlayOperation(user, game, credits, isTry, true, date);
			userGamePlayOperationRepository.save(userPlayOperation);
		} else if (win == false && isTry == false){
			UserGamePlayOperation userPlayOperation = new UserGamePlayOperation(user, game, 0, isTry, true, date);
			userGamePlayOperationRepository.save(userPlayOperation);
		}

		UserGameBuyOperation userBuyOperation = new UserGameBuyOperation(user, game, date);
		userGameBuyOperationRepository.save(userBuyOperation);
	}

	public List<UserCreditsOperation> fetchCreditOperations() {
		return userCreditsOperationsRepository.findAll();
	}

}
