package com.agile.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agile.model.User;
import org.springframework.transaction.annotation.Transactional;

//@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);

    User findByNameEquals(String name);

    User findByUsernameAndPassword(String username, String password);

    User findById(int id);

    /*@Query("select r from Role r where r.id = ?1")
    Role findRoleByUserId(Integer id);*/
}