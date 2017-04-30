package com.agile.repositories;

import com.agile.model.UserCreditsOperation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserCreditsOperationsRepository extends JpaRepository<UserCreditsOperation, Integer> {
    void deleteByUserId(int userId);
}
