package com.agile.repositories;


import com.agile.model.AdminViewOperation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminViewOperationRepository extends JpaRepository<AdminViewOperation, Integer> {
    void deleteByUserId(int userId);
}
