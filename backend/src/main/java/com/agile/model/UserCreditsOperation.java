package com.agile.model;

import java.sql.Timestamp;

import javax.persistence.*;

import com.agile.model.enums.OperationEnum;

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
	private OperationEnum operation;

	@Column(nullable = false)
	private Timestamp date;

	protected UserCreditsOperation() {}

    public UserCreditsOperation(User user, int creditsAddedRemoved, OperationEnum operation, Timestamp date) {
        this.user = user;
        this.creditsAddedRemoved = creditsAddedRemoved;
        this.operation = operation;
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

	public OperationEnum getOperation() {
		return operation;
	}

	public void setOperation(OperationEnum operation) {
		this.operation = operation;
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
