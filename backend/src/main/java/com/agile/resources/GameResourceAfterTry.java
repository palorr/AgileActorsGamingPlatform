package com.agile.resources;

/**
 * resource containing the response values
 * 
 * @author NikosMas
 *
 */
public class GameResourceAfterTry {

	private boolean isWin;
	private boolean hasEnoughTries;

	/**
	 * @param isWin
	 * @param hasEnoughTries
	 */
	public GameResourceAfterTry(boolean isWin, boolean hasEnoughTries) {
		super();
		this.isWin = isWin;
		this.hasEnoughTries = hasEnoughTries;
	}

	public boolean isWin() {
		return isWin;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	public boolean isHasEnoughCredits() {
		return hasEnoughTries;
	}

	public void setHasEnoughCredits(boolean hasEnoughTries) {
		this.hasEnoughTries = hasEnoughTries;
	}
}
