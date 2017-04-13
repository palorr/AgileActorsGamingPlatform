package com.agile.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="user_game_buy_operations")
public class UserGameBuyOperation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne(optional = false)
	private User user;

	@ManyToOne(optional = false)
	private Game game;

	@Column(nullable = false)
	private Timestamp date;

	protected UserGameBuyOperation() {}

    public UserGameBuyOperation(User user, Game game, Timestamp date) {
        this.user = user;
        this.game = game;
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

	public Game getGame() {
		return game;
	}

	public void setGame(Game game_id) {
		this.game = game;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "UserGameBuyOperation [id=" + id + ", user=" + user + ", game=" + game + ", date=" + date + "]";
	}
	
}
