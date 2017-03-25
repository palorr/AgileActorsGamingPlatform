package com.example.repositories;

import java.util.List;

import com.example.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findBySurname(String surname);
}