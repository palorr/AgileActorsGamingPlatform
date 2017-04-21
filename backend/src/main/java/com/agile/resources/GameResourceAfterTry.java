package com.agile.resources;

/**
 * resource containing the response values
 * 
 * @author NikosMas
 *
 */
public class GameResourceAfterTry {

	private boolean isWin;
	private int currentTryNumber;

	/**
	 * @param isWin
	 * @param currentTryNumber
	 */
	public GameResourceAfterTry(boolean isWin, int currentTryNumber) {
		super() ;
		this.isWin = isWin ;
		this.currentTryNumber = currentTryNumber ;
	}

	public boolean isWin() {
		return isWin;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}

	public int getCurrentTryNumber() {
		return currentTryNumber;
	}

	public void setCurrentTryNumber(int currentTryNumber) {
		this.currentTryNumber = currentTryNumber;
	}
}
