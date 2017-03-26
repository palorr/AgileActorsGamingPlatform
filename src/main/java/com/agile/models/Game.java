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
    private double yield;
    private String name;
    private String description;


    protected Game() {}

    public Game(int id, int buy_credits, int win_credits, String name, String description, double yield) {
        this.id = id;
        this.buy_credits = buy_credits;
        this.win_credits = win_credits;
        this.name = name;
        this.description = description;
        this.yield = yield;
    }

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

    public void setYield(double yield) {
        this.yield = yield;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}