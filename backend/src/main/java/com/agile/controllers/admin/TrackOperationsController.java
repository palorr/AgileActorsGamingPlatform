package com.agile.controllers.admin;

import com.agile.model.AdminViewOperation;
import com.agile.model.UserCreditsOperation;
import com.agile.model.UserGameBuyOperation;
import com.agile.model.UserGamePlayOperation;
import com.agile.repositories.AdminViewOperationRepository;
import com.agile.repositories.UserCreditsOperationsRepository;
import com.agile.repositories.UserGameBuyOperationRepository;
import com.agile.repositories.UserGamePlayOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrackOperationsController {

    @Autowired
    private UserCreditsOperationsRepository userCreditsOperationsRepository;

    @Autowired
    private UserGameBuyOperationRepository userGameBuyOperationRepository;

    @Autowired
    private UserGamePlayOperationRepository userGamePlayOperationRepository;

    @Autowired
    private AdminViewOperationRepository adminViewOperationRepository;


    @GetMapping(value = "/UserCreditsOperations")
    public List<UserCreditsOperation> getUserCreditsOperations() {
        return userCreditsOperationsRepository.findAll();
    }

    @GetMapping(value = "/UserSoldGamesOperations")
    public List<UserGameBuyOperation> getSoldGames() {
        return userGameBuyOperationRepository.findAll();
    }

    @GetMapping(value = "/UserGamePlayOperations")
    public List<UserGamePlayOperation> getUserGamePlayOperations() {
        return userGamePlayOperationRepository.findAll();
    }

    @GetMapping(value = "/AdminViewOperation")
    public List<AdminViewOperation> getRoles() {
        return adminViewOperationRepository.findAll();
    }
}
