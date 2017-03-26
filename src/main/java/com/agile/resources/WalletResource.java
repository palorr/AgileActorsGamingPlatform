package com.agile.resources;

public class WalletResource {

	private int id;
	private int user_id;
	private int credits;
	
	public WalletResource(int id, int user_id, int credits) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.credits = credits;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
}
