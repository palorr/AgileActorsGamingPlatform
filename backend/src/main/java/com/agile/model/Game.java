package com.agile.model;


import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private int buy_credits;

    @Column(nullable = false)
    private int win_credits;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String avatar;

    @Column(nullable = false)
    private double yield;

    protected Game() {}

    public Game(int buy_credits, int win_credits, String name, String description,String avatar, double yield) {
        this.buy_credits = buy_credits;
        this.win_credits = win_credits;
        this.name = name;
        this.description = description;
        this.avatar = avatar;

        if(yield>1.0) //yield cant be over 100% win percentage
            this.yield = 1;
        else
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public double getYield() {
        return yield;
    }

    public void setYield(double yield) {
        if(yield>1.0) //yield cant be over 100% win percentage
            this.yield = 1;
        else
            this.yield = yield;
    }

    @Override
	public String toString() {
		return "Game [id=" + id + ", buy_credits=" + buy_credits + ", win_credits=" + win_credits +
                ", name=" + name + ", description=" + description + "]";
	}
}