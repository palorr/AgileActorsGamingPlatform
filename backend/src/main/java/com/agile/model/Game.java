package com.agile.model;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "buy_credits", nullable = false)
    private int buyCredits;

    @Column(name = "win_credits", nullable = false)
    private int winCredits;

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
        this.buyCredits = buy_credits;
        this.winCredits = win_credits;
        this.name = name;
        this.description = description;
        this.avatar = avatar;

        if(yield>1.0) //yield cant be over 100% win percentage
            this.yield = 1;
        else
            this.yield = yield;
    }

    @PrePersist
    public void prePersist() {
        if(this.avatar == null) {
            this.avatar = "http://enadcity.org/enadcity/wp-content/uploads/2017/02/profile-pictures.png";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuy_credits() {
        return buyCredits;
    }

    public void setBuy_credits(int buyCredits) {
        this.buyCredits = buyCredits;
    }

    public int getWin_credits() {
        return winCredits;
    }

    public void setWin_credits(int winCredits) {
        this.winCredits = winCredits;
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
		return "Game [id=" + id + ", buy_credits=" + buyCredits + ", win_credits=" + winCredits +
                ", name=" + name + ", description=" + description + "]";
	}
}