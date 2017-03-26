package com.agile.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_credits_operations")
public class UserCreditsOperation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int user_id;
	private int transaction_id;
	private int credits_added_removed;
	private String operation;
	private Date date;
	
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
	@Override
	public String toString() {
		return "UserCreditsOperation [id=" + id + ", user_id=" + user_id + ", transaction_id=" + transaction_id
				+ ", credits_added_removed=" + credits_added_removed + ", operation=" + operation + ", date=" + date
				+ "]";
	}
	
}
