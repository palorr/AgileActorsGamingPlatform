package com.agile.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_game_play_operations")
public class UserGamePlayOperation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int user_id;
	private int game_id;
	private int win_credits;
	private Boolean is_try;
	private Boolean is_win;
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
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public int getWin_credits() {
		return win_credits;
	}
	public void setWin_credits(int win_credits) {
		this.win_credits = win_credits;
	}
	public Boolean getIs_try() {
		return is_try;
	}
	public void setIs_try(Boolean is_try) {
		this.is_try = is_try;
	}
	public Boolean getIs_win() {
		return is_win;
	}
	public void setIs_win(Boolean is_win) {
		this.is_win = is_win;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "UserGamePlayOperation [id=" + id + ", user_id=" + user_id + ", game_id=" + game_id + ", win_credits="
				+ win_credits + ", is_try=" + is_try + ", is_win=" + is_win + ", date=" + date + "]";
	}
	
}
