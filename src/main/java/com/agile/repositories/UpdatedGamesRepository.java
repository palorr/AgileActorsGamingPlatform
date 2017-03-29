package com.agile.repositories;

import com.agile.models.UpdatedGames;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdatedGamesRepository extends JpaRepository<UpdatedGames, Integer> {
}
