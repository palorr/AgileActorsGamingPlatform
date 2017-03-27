package com.agile.resources;

public class UserResource {

	private int id;
    private int roles_id;
    private String name;
    private String surname;
    private String username;
    private String password;
    
	public UserResource(int id, int roles_id, String name, String surname, String username, String password) {
		super();
		this.id = id;
		this.roles_id = roles_id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.password = password;
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
    
}
