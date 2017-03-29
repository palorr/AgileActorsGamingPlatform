package com.agile.controllers;

import com.agile.models.Wallet;
import com.agile.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WalletController {

    @Autowired
    private WalletRepository walletRepository;

    @RequestMapping(value = "/wallets", method = RequestMethod.GET)
    @ResponseBody
    public List<Wallet> getWallets() {
        return walletRepository.findAll();
    }
}
