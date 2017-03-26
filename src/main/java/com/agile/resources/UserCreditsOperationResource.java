package com.agile.resources;

import java.sql.Date;

public class UserCreditsOperationResource {

	private int id;
	private int user_id;
	private int transaction_id;
	private int credits_added_removed;
	private String operation;
	private Date date;
	
	public UserCreditsOperationResource(int id, int user_id, int transaction_id, int credits_added_removed,
			String operation, Date date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.transaction_id = transaction_id;
		this.credits_added_removed = credits_added_removed;
		this.operation = operation;
		this.date = date;
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
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getCredits_added_removed() {
		return credits_added_removed;
	}
	public void setCredits_added_removed(int credits_added_removed) {
		this.credits_added_removed = credits_added_removed;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
