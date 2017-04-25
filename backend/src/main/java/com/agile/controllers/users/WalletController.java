package com.agile.controllers.users;

import com.agile.resources.WalletDepositAnswerResource;
import com.agile.resources.WalletOpeartionsResource;
import com.agile.resources.WalletResource;
import com.agile.resources.WalletWithdrawAnswerResource;
import com.agile.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:5555")
@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping(value = "rest/wallet/{userId}")
    public WalletResource getWalletByUserId(@PathVariable(value = "userId") int userId) {
        return walletService.getWalletByUserId(userId);
    }
    
    @PostMapping(value = "rest/wallet/deposit")
    public WalletDepositAnswerResource deposit(@RequestBody WalletOpeartionsResource resource){
		return walletService.deposit(resource);
    }
    
    @PostMapping(value = "rest/wallet/withdraw")
    public WalletWithdrawAnswerResource withdraw(@RequestBody WalletOpeartionsResource resource){
		return walletService.withdraw(resource);
    }

}
