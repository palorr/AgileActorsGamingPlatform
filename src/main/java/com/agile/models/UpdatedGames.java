package com.agile.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="updated_games")
public class UpdatedGames {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int game_id;
	private int user_id;
	private Date update_date;
	
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
	@Override
	public String toString() {
		return "UpdatedGames [id=" + id + ", game_id=" + game_id + ", user_id=" + user_id + ", update_date="
				+ update_date + "]";
	}
	
	
}
