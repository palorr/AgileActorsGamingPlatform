package com.agile.resources;

public class GameResource {

	private int id;
    private int buy_credits;
    private int win_credits;
    private Double yield;
    private String name;
    private String description;
	
	public GameResource(int id, int buy_credits, int win_credits, String name, String description, Double yield) {
        this.id = id;
        this.buy_credits = buy_credits;
        this.win_credits = win_credits;
        this.name = name;
        this.description = description;
        this.yield = yield;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuy_credits() {
		return buy_credits;
	}

	public void setBuy_credits(int buy_credits) {
		this.buy_credits = buy_credits;
	}

	public int getWin_credits() {
		return win_credits;
	}

	public void setWin_credits(int win_credits) {
		this.win_credits = win_credits;
	}

	public Double getYield() {
		return yield;
	}

	public void setYield(Double yield) {
		this.yield = yield;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
