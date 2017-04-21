package com.agile.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tries")
public class Tries {

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private int gameId;
	private int userId;
	private int tryNum;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTryNum() {
		return tryNum;
	}
	public void setTryNum(int tryNum) {
		this.tryNum = tryNum;
	}
	
	@Override
	public String toString() {
		return "Tries [id=" + id + ", gameId=" + gameId + ", userId=" + userId + ", tryNum=" + tryNum + "]";
	}
	
}
