package com.agile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);
}