package com.example.dao;

import com.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {

        List<User> result = jdbcTemplate.query(
                "SELECT * FROM users",
                (rs, rowNum) -> new User(rs.getInt("id"), rs.getInt("roles_id"), rs.getString("name"),
                        rs.getString("surname"), rs.getString("username"), rs.getString("password"))
        );

        return result;

    }

    public void addUser(String name, String surname, String username, String password, Integer roles_id) {

        jdbcTemplate.update("INSERT INTO user(name, surname, username, password, roles_id) VALUES (?,?,?,?,?)",
                name, surname, username, password, roles_id);

    }


}