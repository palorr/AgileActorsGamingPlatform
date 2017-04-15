package com.agile.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="user_credits_operations")
public class UserCreditsOperation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne(optional = false)
	private User user;

	@Column(name = "credits_added_removed", nullable = false)
	private int creditsAddedRemoved;

	@Column(nullable = false)
	private String operation;

	@Column(nullable = false)
	private Timestamp date;

	public enum OperationEnum {
		ADDED("added"),
		REMOVED("removed");

		private String description;

		OperationEnum(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}

	protected UserCreditsOperation() {}

    public UserCreditsOperation(User user, int creditsAddedRemoved, OperationEnum operation, Timestamp date) {
        this.user = user;
        this.creditsAddedRemoved = creditsAddedRemoved;
        this.operation = operation.getDescription();
        this.date = date;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser_id(User user) {
		this.user = user;
	}

	public int getCreditsAddedRemoved() {
		return creditsAddedRemoved;
	}

	public void setCreditsAddedRemoved(int creditsAddedRemoved) {
		this.creditsAddedRemoved = creditsAddedRemoved;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(OperationEnum operation) {
		this.operation = operation.getDescription();
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "UserCreditsOperation [id=" + id + ", user=" + user
				+ ", creditsAddedRemoved=" + creditsAddedRemoved + ", operation=" + operation + ", date=" + date
				+ "]";
	}
}
