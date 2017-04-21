package com.agile.controllers.users;

import com.agile.resources.DepositResponseResource;
import com.agile.resources.WalletDepositResource;
import com.agile.resources.WalletResource;
import com.agile.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//@CrossOrigin(origins = "http://localhost:5555")
@RestController
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping(value = "/wallet/{userId}")
    public WalletResource getWalletByUserId(@PathVariable(value = "userId") int userId) {
        return walletService.getWalletByUserId(userId);
    }
    
    @PostMapping(value = "/wallet/deposit")
    public DepositResponseResource deposit(@RequestBody WalletDepositResource resource){
		return walletService.deposit(resource);
    }

}
