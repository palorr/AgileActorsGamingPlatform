package com.agile.repositories;


import com.agile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<User, Integer> {
}
