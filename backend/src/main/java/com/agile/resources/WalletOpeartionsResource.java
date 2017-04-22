package com.agile.resources;

public class WalletOpeartionsResource {

	private int userId;
	private String number;
	private int credits;
	
	public WalletOpeartionsResource(int userId, String number, int credits) {
		super();
		this.userId = userId;
		this.number = number;
		this.credits = credits;
	}
	
	public WalletOpeartionsResource() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	
}
