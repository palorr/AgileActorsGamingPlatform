package com.agile.resources;

public class WalletWithdrawAnswerResource {

	private boolean success;
	private boolean overLimit;
	private boolean hasEnoughCredits;
	private int credits;
	
	public WalletWithdrawAnswerResource(boolean success, boolean overLimit, boolean hasEnoughCredits, int credits) {
		super();
		this.success = success;
		this.overLimit = overLimit;
		this.hasEnoughCredits = hasEnoughCredits;
		this.credits = credits;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public boolean isOverLimit() {
		return overLimit;
	}
	public void setOverLimit(boolean overLimit) {
		this.overLimit = overLimit;
	}
	public boolean isHasEnoughCredits() {
		return hasEnoughCredits;
	}
	public void setHasEnoughCredits(boolean hasEnoughCredits) {
		this.hasEnoughCredits = hasEnoughCredits;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	
	
	
	
}
