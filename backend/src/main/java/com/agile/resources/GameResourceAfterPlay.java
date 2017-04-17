package com.agile.resources;

/**
 * resource containing the response values
 * 
 * @author NikosMas
 *
 */
public class GameResourceAfterPlay {

	private boolean isWin;
	private boolean hasEnoughCredits;
	private int ammountWon;

	/**
	 * @param isWin
	 * @param hasEnoughCredits
	 * @param ammountWon
	 */
	public GameResourceAfterPlay(boolean isWin, boolean hasEnoughCredits, int ammountWon) {
		super();
		this.isWin = isWin;
		this.hasEnoughCredits = hasEnoughCredits;
		this.ammountWon = ammountWon;
	}

	public boolean isWin() {
		return isWin;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	public boolean isHasEnoughCredits() {
		return hasEnoughCredits;
	}

	public void setHasEnoughCredits(boolean hasEnoughCredits) {
		this.hasEnoughCredits = hasEnoughCredits;
	}

	public int getAmmountWon() {
		return ammountWon;
	}

	public void setAmmountWon(int ammountWon) {
		this.ammountWon = ammountWon;
	}
}
