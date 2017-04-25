package com.agile.model;

import java.sql.Timestamp;

import javax.persistence.*;

import com.agile.model.enums.OperationEnum;

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
	private OperationEnum operation;

	@Column(nullable = false)
	private Timestamp date;

	protected AdminGameOperation() {}

    public AdminGameOperation(User user, Game game, OperationEnum operation, Timestamp date) {
        this.user = user;
        this.game = game;
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

	public void setUser(User user) {
		this.user = user; }

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
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
		return "AdminGameOperation [id=" + id + ", user=" + user + ", game=" + game + ", operation="
				+ operation.getDescription() + ", date=" + date + "]";
	}
}
