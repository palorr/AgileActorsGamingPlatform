package com.agile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.models.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

    Game findByName(String name);

}