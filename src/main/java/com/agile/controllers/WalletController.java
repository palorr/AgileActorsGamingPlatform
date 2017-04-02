package com.agile.controllers;

import com.agile.models.Wallet;
import com.agile.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {

    @Autowired
    private WalletRepository walletRepository;

    @GetMapping(value = "/wallets")
    public List<Wallet> getWallets() {
        return walletRepository.findAll();
    }
}
