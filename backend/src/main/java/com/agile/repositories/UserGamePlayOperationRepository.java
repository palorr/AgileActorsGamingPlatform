package com.agile.repositories;

import com.agile.model.UserGamePlayOperation;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserGamePlayOperationRepository extends JpaRepository<UserGamePlayOperation, Integer> {
	void deleteByUserId(int userId);

	List<UserGamePlayOperation> findTop10ByIsWinOrderByDateDesc(boolean isWin);

	@Query(value = "select new com.agile.repositories.CountGame(u.game.id, count(u.game.id)) from UserGamePlayOperation u group by u.game.id order by count(u.game.id)")
	List<CountGame> findGames(Pageable page);
}
