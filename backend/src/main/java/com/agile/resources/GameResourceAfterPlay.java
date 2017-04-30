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
	private int amountWon;

	/**
	 * @param isWin
	 * @param hasEnoughCredits
	 * @param amountWon
	 */
	public GameResourceAfterPlay(boolean isWin, boolean hasEnoughCredits, int amountWon) {
		super();
		this.isWin = isWin;
		this.hasEnoughCredits = hasEnoughCredits;
		this.amountWon = amountWon;
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

	public int getAmountWon() {
		return amountWon;
	}

	public void setAmountWon(int amountWon) {
		this.amountWon = amountWon;
	}
}
