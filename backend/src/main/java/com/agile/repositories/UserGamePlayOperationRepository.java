package com.agile.repositories;

import com.agile.model.UserGamePlayOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGamePlayOperationRepository extends JpaRepository<UserGamePlayOperation, Integer> {
    void deleteByUserId(int userId);
}
