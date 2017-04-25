package com.agile.model;

import javax.persistence.*;

@Entity
@Table(name="wallets")
public class Wallet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int credits;

	@OneToOne(mappedBy = "wallet")
	private User user;

	public Wallet() {
		this.credits = 0;
	}

	public Wallet(int credits) {
		this.credits = credits;
	}

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Wallet [id =" + id + ", credits =" + credits + ", user =" + user + "]";
	}
}
