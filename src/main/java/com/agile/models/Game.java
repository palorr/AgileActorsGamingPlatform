package com.agile.models;


import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int buy_credits;
    private int win_credits;
    private Double yield;
    private String name;
    private String description;

    // Getters
    public int getId() {
        return id;
    }

    public int getBuy_credits() {
        return buy_credits;
    }

    public int getWin_credits() {
        return win_credits;
    }

    public double getYield() {
        return yield;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setBuy_credits(int buy_credits) {
        this.buy_credits = buy_credits;
    }

    public void setWin_credits(int win_credits) {
        this.win_credits = win_credits;
    }

    public void setYield(Double yield) {
        this.yield = yield;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	@Override
	public String toString() {
		return "Game [id=" + id + ", buy_credits=" + buy_credits + ", win_credits=" + win_credits + ", yield=" + yield
				+ ", name=" + name + ", description=" + description + "]";
	}
    
    
}