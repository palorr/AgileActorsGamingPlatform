package com.agile.resources;

/**
 * resource containing the user information we want to show
 * 
 * @author NikosMas
 *
 */
public class UserResource {

	private int id;
	private String name;
	private String surname;
	private String username;
	private String avatar;

	public UserResource() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 * @param surname
	 * @param username
	 * @param avatar
	 */
	public UserResource(int id, String name, String surname, String username, String avatar) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
