package com.agile.resources;

public class WalletDepositResource {

	private int userId;
	private String number;
	private int credits;
	
	public WalletDepositResource(int userId, String number, int credits) {
		super();
		this.userId = userId;
		this.number = number;
		this.credits = credits;
	}
	
	public WalletDepositResource() {
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
