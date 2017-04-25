package com.agile.services.api;

import com.agile.model.Wallet;
import com.agile.resources.WalletDepositAnswerResource;
import com.agile.resources.WalletOperationsResource;
import com.agile.resources.WalletResource;
import com.agile.resources.WalletWithdrawAnswerResource;

import java.util.List;

public interface WalletServiceInterface {
    List<Wallet> fetchWallets();
    WalletWithdrawAnswerResource withdraw(WalletOperationsResource resource);
    WalletDepositAnswerResource deposit(WalletOperationsResource resource);
    WalletResource getWalletByUserId(int userId);
    Wallet updateWalletCredits(Wallet wallet);
    Wallet findWalletById(int id);

}
