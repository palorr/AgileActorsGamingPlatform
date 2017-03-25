package com.example.models;

import com.sun.xml.internal.bind.v2.TODO;

public class User {

    private int id;
    private int roles_id;
    private String name;
    private String surname;
    private String username;
    private String password;

    public User(int id, int roles_id, String name, String surname, String username, String password) {
        this.id = id;
        this.roles_id = roles_id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getRoles_id() {
        return roles_id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setRoles_id(int roles_id) {
        this.roles_id = roles_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String role() {
        // #TODO get role ids from database through role model
        if (this.getRoles_id() == 1) {
            return "User";
        }
        else if (this.getRoles_id() == 2) {
            return "Admin";
        }
        else {
            return "Undefined";
        }
    }
}