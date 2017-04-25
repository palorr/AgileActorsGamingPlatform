package com.agile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);

    User findByNameEquals(String name);

    User findByUsernameAndPassword(String username, String password);

    List<User> findByNameStartingWith(String searchTerm);

    List<User> findByNameStartingWithOrSurnameStartingWithOrUsernameStartingWith(String param1, String param2, String param3 );

    User findById(int id);

    User findByUsername(String username);
}