package com.agile.models;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int roles_id;
    private String name;
    private String surname;
    private String username;
    private String password;

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

	@Override
	public String toString() {
		return "User [id=" + id + ", roles_id=" + roles_id + ", name=" + name + ", surname=" + surname + ", username="
				+ username + ", password=" + password + "]";
	}

}