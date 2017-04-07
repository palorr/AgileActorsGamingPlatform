package com.agile.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="user_game_play_operations")
public class UserGamePlayOperation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@ManyToOne(optional = false)
	private User user;

	@ManyToOne(optional = false)
	private Game game;

	@Column(name = "win_credits", nullable = false)
	private int winCredits;

	@Column(name = "is_try", nullable = false)
	private Boolean isTry;

	@Column(name = "is_win", nullable = false)
	private Boolean isWin;

	@Column(nullable = false)
	private Timestamp date;

	protected UserGamePlayOperation() {}
	
    public UserGamePlayOperation(User user, Game game, int winCredits, Boolean isTry, Boolean isWin, Timestamp date) {
		this.user = user;
        this.game = game;
        this.winCredits = winCredits;
        this.isTry = isTry;
        this.isWin = isWin;
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

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public int getWinCredits() {
		return winCredits;
	}

	public void setWinCredits(int winCredits) {
		this.winCredits = winCredits;
	}

	public Boolean getIsTry() { return isTry; }

	public void setIsTry(Boolean isTry) {
		this.isTry = isTry;
	}

	public Boolean getIsWin() {
		return isWin;
	}

	public void setIsWin(Boolean is_win) {
		this.isWin = is_win;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "UserGamePlayOperation [id=" + id + ", user=" + user + ", game=" + game + ", winCredits="
				+ winCredits + ", isTry=" + isTry + ", isWin=" + isWin + ", date=" + date + "]";
	}
	
}
