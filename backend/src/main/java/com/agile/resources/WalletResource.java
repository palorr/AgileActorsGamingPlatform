package com.agile.resources;

public class WalletResource {

    private int id ;
    private int credits ;

    public WalletResource(int id, int credits) {
        this.id = id;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public int getCredits() {
        return credits;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
