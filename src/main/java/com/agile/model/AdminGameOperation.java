package com.agile.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="admin_game_operations")
public class AdminGameOperation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne(optional = false)
	private User user;

	@ManyToOne(optional = false)
	private Game game;

	@Column(nullable = false)
	private String operation;

	@Column(nullable = false)
	private Timestamp date;

	public enum OperationEnum {
		ADDED("added"),
		MODIFIED("modified"),
		REMOVED("removed");

		private String url;

		OperationEnum(String url) {
			this.url = url;
		}

		public String get() {
			return url;
		}
	}

	protected AdminGameOperation() {}

    public AdminGameOperation(User user, Game game, UserCreditsOperation.OperationEnum operation, Timestamp date) {
        this.user = user;
        this.game = game;
        this.operation = operation.get();
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

	public void setUser(User user) { this.user = user; }

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
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
		return "AdminGameOperation [id=" + id + ", user=" + user + ", game=" + game + ", operation="
				+ operation + ", date=" + date + "]";
	}
}
