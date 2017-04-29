package com.agile.resources;

public class UserToRegister {

    private String username;
    private String name ;
    private String surname ;
    private String password;
    private String confirmedPassword;

    public UserToRegister() {
        super();
    }

    public UserToRegister(String username, String name, String surname, String password, String confirmedPassword) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public boolean areBothPasswordsTheSame(){
        if(this.getPassword().equals(this.getConfirmedPassword())){
            return true;
        }
        return false ;
    }
}
