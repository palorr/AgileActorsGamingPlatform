package com.agile.resources;

import java.sql.Timestamp;

public class WinGamesResource {

	private String username;
	private String gameName;
	private int creditsWon;
	private Timestamp date;
	
	public WinGamesResource(String username, String gameName, int creditsWon, Timestamp date) {
		super();
		this.username = username;
		this.gameName = gameName;
		this.creditsWon = creditsWon;
		this.date = date;
	}
	
	public WinGamesResource() {
		super();
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public int getCreditsWon() {
		return creditsWon;
	}
	public void setCreditsWon(int creditsWon) {
		this.creditsWon = creditsWon;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	} 
	
	
	
}
