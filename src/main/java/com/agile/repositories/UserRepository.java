package com.agile.repositories;

import java.util.List;

import com.agile.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByName(String name);
}