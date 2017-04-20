package com.agile.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    static final long serialVersionUID = 1L;

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

    protected User() {}

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

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // we never lock accounts
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // credentials never expire
        return true;
    }

    @Override
    public boolean isEnabled() {
        // all users are enabled
        return true;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
}
