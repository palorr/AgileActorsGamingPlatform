package com.agile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.model.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

    Game findByName(String name);

}