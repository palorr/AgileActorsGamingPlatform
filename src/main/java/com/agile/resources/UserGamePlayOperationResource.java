package com.agile.resources;

import java.sql.Date;

public class UserGamePlayOperationResource {

	private int id;
	private int user_id;
	private int game_id;
	private int win_credits;
	private Boolean is_try;
	private Boolean is_win;
	private Date date;
	
	public UserGamePlayOperationResource(int id, int user_id, int game_id, int win_credits, Boolean is_try,
			Boolean is_win, Date date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.game_id = game_id;
		this.win_credits = win_credits;
		this.is_try = is_try;
		this.is_win = is_win;
		this.date = date;
	}
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
	
}
