package com.agile.services;

import javax.transaction.Transactional;

import com.agile.model.User;
import com.agile.repositories.UserRepository;
import com.agile.resources.WalletDepositAnswerResource;
import com.agile.resources.WalletOperationsResource;
import com.agile.resources.WalletResource;
import com.agile.resources.WalletWithdrawAnswerResource;

import com.agile.services.api.WalletServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.model.Wallet;
import com.agile.model.enums.CouponNumbersEnum;
import com.agile.repositories.WalletRepository;

import java.util.List;

@Service
public class WalletService implements WalletServiceInterface{

	private WalletRepository walletRepository;
	private UserRepository userRepository;
	private UserService userService;

	@Autowired
	public WalletService(UserRepository userRepository, WalletRepository walletRepository, UserService userService) {

		this.userRepository = userRepository;
		this.userService = userService;
		this.walletRepository = walletRepository;
	}

	@Override
	public List<Wallet> fetchWallets() {
		return walletRepository.findAll();
	}

	@Override
	@Transactional
	public Wallet findWalletById(int id) {
		return walletRepository.findOne(id);
	}

	@Override
	@Transactional
	public Wallet updateWalletCredits(Wallet wallet) {
		return walletRepository.save(wallet);
	}

	@Override
	@Transactional
	public WalletResource getWalletByUserId(int userId) {
		Wallet wallet = userRepository.findById(userId).getWallet();
		return new WalletResource(wallet.getId(), wallet.getCredits());
	}

	@Override
	@Transactional
	public WalletDepositAnswerResource deposit(WalletOperationsResource resource) {

		boolean success = false;
		Integer creditsInserted = 0;

		if (userService.findUserById(resource.getUserId()) != null
				&& (resource.getNumber().equals(CouponNumbersEnum.COUPON_1.getDescription())
						|| resource.getNumber().equals(CouponNumbersEnum.COUPON_2.getDescription())
						|| resource.getNumber().equals(CouponNumbersEnum.COUPON_3.getDescription()))) {

			User userToDeposit = userService.findUserById(resource.getUserId());
			Wallet wallet = userToDeposit.getWallet();
			int existedCredits = wallet.getCredits();

			wallet.setCredits(existedCredits + resource.getCredits());
			walletRepository.save(wallet);

			return new WalletDepositAnswerResource(true, resource.getCredits());
		}

		return new WalletDepositAnswerResource(success, creditsInserted);
	}

	@Override
	public WalletWithdrawAnswerResource withdraw(WalletOperationsResource resource) {
		boolean success = false;
		Integer creditsTaken = 0;
		boolean overLimit = false;
		boolean hasEnoughCredits = false;


		if (userService.findUserById(resource.getUserId()) != null && resource.getNumber().substring(0, 2).equals("GR") && resource.getNumber().length() == 34) {
			success = true;

			Wallet wallet = userService.findUserById(resource.getUserId()).getWallet();
			int existedCredits = wallet.getCredits();

			if (resource.getCredits()>=30) {

				overLimit = true;
				if (resource.getCredits() <= existedCredits) {

					hasEnoughCredits = true;
					creditsTaken = resource.getCredits();
					wallet.setCredits(existedCredits - resource.getCredits());
					walletRepository.save(wallet);
				}
			}
			return new WalletWithdrawAnswerResource(success, overLimit, hasEnoughCredits, creditsTaken);
		}
		return new WalletWithdrawAnswerResource(success, overLimit, hasEnoughCredits, creditsTaken);
	}
}
