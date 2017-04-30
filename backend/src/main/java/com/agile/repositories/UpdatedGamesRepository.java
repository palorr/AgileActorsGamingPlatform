package com.agile.repositories;

import com.agile.model.UpdatedGames;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdatedGamesRepository extends JpaRepository<UpdatedGames, Integer> {
    void deleteByUserId(int userId);
}
