package com.example.repositories;

import java.util.List;

import com.example.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {

    List<Game> findByName(String name);
}