package com.agile.controllers;

import com.agile.models.UpdatedGames;
import com.agile.models.User;
import com.agile.repositories.UpdatedGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UpdatedGamesController {

    @Autowired
    private UpdatedGamesRepository updatedGamesRepository;

    @GetMapping(value = "/updatedGames")
    public List<UpdatedGames> getUpdatedGames() {
        List<UpdatedGames> updatedGames = updatedGamesRepository.findAll();
        return updatedGames;
    }
}
