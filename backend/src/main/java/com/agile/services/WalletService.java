package com.agile.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.agile.model.Wallet;
import com.agile.repositories.WalletRepository;

@Service
public class WalletService {

	private WalletRepository walletRepository;

	public WalletService(WalletRepository walletRepository) {
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
}
