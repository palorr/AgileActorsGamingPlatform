package com.agile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.model.Game;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Integer> {

    Game findByName(String name);
    List<Game> findByNameStartingWith(String searchTerm);
    Game findById(int id);
}