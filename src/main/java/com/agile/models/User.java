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

    protected User() {}

    public User(int roles_id, String name, String surname, String username, String password) {
        this.roles_id = roles_id;
        this.name = name;
        this.surname = surname;
        this.username = username;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(int roles_id) {
        this.roles_id = roles_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
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