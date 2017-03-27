package com.agile.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_game_buy_operations")
public class UserGameBuyOperation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int user_id;
	private int game_id;
	private Date date;

    public UserGameBuyOperation(int user_id, int game_id, Date date) {
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
	@Override
	public String toString() {
		return "UserGameBuyOperation [id=" + id + ", user_id=" + user_id + ", game_id=" + game_id + ", date=" + date
				+ "]";
	}
	
}
