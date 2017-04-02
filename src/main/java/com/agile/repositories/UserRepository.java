package com.agile.repositories;

import java.util.List;

import com.agile.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.models.User;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);

    User findByNameEquals(String name);

    /*@Query("select r from Role r where r.id = ?1")
    Role findRoleByUserId(Integer id);*/
}