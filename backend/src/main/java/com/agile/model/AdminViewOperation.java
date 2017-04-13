package com.agile.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="admin_view_operations")
public class AdminViewOperation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne(optional = false)
	private User user;

	@Column(nullable = false)
	private Timestamp date;

	protected AdminViewOperation() {}

    public AdminViewOperation(User user, Timestamp date) {
        this.user = user;
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

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "AdminViewOperation [id=" + id + ", user=" + user + ", date=" + date + "]";
	}
}
