package com.agile.resources;

import java.sql.Date;

public class UpdatedGamesResource {

	private int id;
	private int game_id;
	private int user_id;
	private Date update_date;
	
	public UpdatedGamesResource(int id, int game_id, int user_id, Date update_date) {
		super();
		this.id = id;
		this.game_id = game_id;
		this.user_id = user_id;
		this.update_date = update_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	
}
