package com.agile.repositories;

import com.agile.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface WalletRepository extends JpaRepository<Wallet, Integer> {
	
//	@Query("update Wallet w set w.credits = :credits where w.id = :id")
//	Wallet updateWalletCredits(int id, int credits);
}
