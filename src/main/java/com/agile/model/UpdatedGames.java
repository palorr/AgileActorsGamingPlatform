package com.agile.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="updated_games")
public class UpdatedGames {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne(optional = false)
	private Game game;

	@ManyToOne(optional = false)
	private User user;

	@Column(name = "update_date", nullable = false)
	private Timestamp updateDate;

	protected UpdatedGames() {}

	public UpdatedGames(Game game, User user, Timestamp updateDate) {
		this.game = game;
		this.user = user;
		this.updateDate = updateDate;
	}

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "UpdatedGames [id=" + id + ", game_id=" + game + ", user_id=" + user + ", update_date="
				+ updateDate + "]";
	}
}
