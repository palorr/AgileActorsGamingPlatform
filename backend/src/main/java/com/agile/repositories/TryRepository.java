package com.agile.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agile.model.Tries;

public interface TryRepository extends JpaRepository<Tries, Integer> {

	Tries findByGameIdAndUserId(int gameId, int userId);
	
}
