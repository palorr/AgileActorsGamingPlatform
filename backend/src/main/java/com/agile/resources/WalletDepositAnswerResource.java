package com.agile.resources;

public class WalletDepositAnswerResource {

	private boolean success;
	private int credits;
	
	public WalletDepositAnswerResource(boolean success, int credits) {
		super();
		this.success = success;
		this.credits = credits;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getCreditsInserted() {
		return credits;
	}
	public void setCreditsInserted(int credits) {
		this.credits = credits;
	}
	
	
	
}
