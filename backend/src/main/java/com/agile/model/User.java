package com.agile.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String avatar;

    @ManyToOne(optional = false)
    private Role role;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    private Wallet wallet;

    public User() {}

    public User(String name, String surname, String username, String password, Role role, Wallet wallet) {
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.avatar = "http://enadcity.org/enadcity/wp-content/uploads/2017/02/profile-pictures.png";//default image on register
        this.wallet = wallet;
    }

    @PrePersist
    public void prePersist() {
        if(this.avatar == null) {
            this.avatar = "http://enadcity.org/enadcity/wp-content/uploads/2017/02/profile-pictures.png";
        }
    }

    public Wallet getWallet() { return wallet; }

    public void setWallet(Wallet wallet) { this.wallet = wallet; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", surname=" + surname + ", username="
				+ username + ", password=" + password + "]";
	}

}