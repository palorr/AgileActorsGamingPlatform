package com.agile.services;

import javax.transaction.Transactional;

import com.agile.model.User;
import com.agile.repositories.UserRepository;
import com.agile.resources.WalletResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.model.Wallet;
import com.agile.repositories.WalletRepository;

@Service
public class WalletService {

	@Autowired
	private WalletRepository walletRepository;

	@Autowired
	private UserRepository userRepository;

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
		Wallet wallet = this.userRepository.findById(userId).getWallet();
		WalletResource walletResource = new WalletResource(wallet.getId() , wallet.getCredits());
		return walletResource ;
	}
}
