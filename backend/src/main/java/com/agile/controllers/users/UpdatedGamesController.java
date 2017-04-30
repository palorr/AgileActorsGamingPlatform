package com.agile.controllers.users;

import com.agile.model.UpdatedGames;
import com.agile.repositories.UpdatedGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UpdatedGamesController {

    @Autowired
    private UpdatedGamesRepository updatedGamesRepository;

    @GetMapping(value = "rest/updatedGames")
    public List<UpdatedGames> getUpdatedGames() {
        List<UpdatedGames> updatedGames = updatedGamesRepository.findAll();
        return updatedGames;
    }
}
