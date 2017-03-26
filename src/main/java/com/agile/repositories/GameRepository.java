package com.agile.repositories;

import java.util.List;

import com.agile.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {

    List<Game> findByName(String name);
}