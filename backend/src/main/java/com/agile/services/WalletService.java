package com.agile.services;

import javax.transaction.Transactional;

import com.agile.model.User;
import com.agile.repositories.UserRepository;
import com.agile.resources.DepositResponseResource;
import com.agile.resources.WalletDepositResource;
import com.agile.resources.WalletResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.model.Wallet;
import com.agile.model.enums.CouponNumbersEnum;
import com.agile.repositories.WalletRepository;

@Service
public class WalletService {

	private WalletRepository walletRepository;
	private UserRepository userRepository;
	private UserService userService;

	@Autowired
	public WalletService(UserRepository userRepository, WalletRepository walletRepository, UserService userService) {

		this.userRepository = userRepository;
		this.userService = userService;
		this.walletRepository = walletRepository;
	}

	@Transactional
	public Wallet findWalletById(int id) {
		return walletRepository.findOne(id);
	}

	@Transactional
	public Wallet updateWalletCredits(Wallet wallet) {
		return walletRepository.save(wallet);
	}

	@Transactional
	public WalletResource getWalletByUserId(int userId) {
		Wallet wallet = userRepository.findById(userId).getWallet();
		return new WalletResource(wallet.getId(), wallet.getCredits());
	}

	@Transactional
	public DepositResponseResource deposit(WalletDepositResource resource) {

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

			return new DepositResponseResource(true, resource.getCredits());
		}

		return new DepositResponseResource(success, creditsInserted);
	}
}
