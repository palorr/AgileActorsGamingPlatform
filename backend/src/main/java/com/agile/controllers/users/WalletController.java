package com.agile.controllers.users;

import com.agile.resources.WalletDepositAnswerResource;
import com.agile.resources.WalletOperationsResource;
import com.agile.resources.WalletResource;
import com.agile.resources.WalletWithdrawAnswerResource;
import com.agile.services.api.WalletServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:5555")
@RestController
public class WalletController {

    @Autowired
    private WalletServiceInterface walletService;

    @GetMapping(value = "rest/wallet/{userId}")
    public WalletResource getWalletByUserId(@PathVariable(value = "userId") int userId) {
        return walletService.getWalletByUserId(userId);
    }
    
    @PostMapping(value = "rest/wallet/deposit")
    public WalletDepositAnswerResource deposit(@RequestBody WalletOperationsResource resource){
		return walletService.deposit(resource);
    }
    
    @PostMapping(value = "rest/wallet/withdraw")
    public WalletWithdrawAnswerResource withdraw(@RequestBody WalletOperationsResource resource){
		return walletService.withdraw(resource);
    }

}
