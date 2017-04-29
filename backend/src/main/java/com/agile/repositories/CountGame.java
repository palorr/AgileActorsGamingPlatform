package com.agile.repositories;

public class CountGame {
	
	private int id;
	private long count;
	
	public CountGame() {
		super();
	}

	public CountGame(int id, long count) {
		super();
		this.id = id;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
	
	

}
