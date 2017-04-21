package com.agile.resources;

public class DepositResponseResource {

	private boolean success;
	private int creditsInserted;
	
	public DepositResponseResource(boolean success, int creditsInserted) {
		super();
		this.success = success;
		this.creditsInserted = creditsInserted;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public int getCreditsInserted() {
		return creditsInserted;
	}
	public void setCreditsInserted(int creditsInserted) {
		this.creditsInserted = creditsInserted;
	}
	
	
	
}
