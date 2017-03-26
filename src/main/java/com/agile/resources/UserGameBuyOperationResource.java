package com.agile.resources;

import java.sql.Date;

public class UserGameBuyOperationResource {

	private int id;
	private int user_id;
	private int game_id;
	private Date date;
	
	public UserGameBuyOperationResource(int id, int user_id, int game_id, Date date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.game_id = game_id;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
