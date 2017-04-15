package com.agile.resources;


/**
 * resource containing the parameters that front-end posts to play game
 * 
 * @author NikosMas
 *
 */
public class GetGameResource {

	private int userId;
	private int gameId;
	
	public GetGameResource() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
}
