package com.agile.repositories;

import com.agile.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WalletRepository extends JpaRepository<Wallet, Integer> {
}
