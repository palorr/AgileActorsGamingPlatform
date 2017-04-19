package com.agile.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    /* validation rules */
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*$";
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@!#$]*$";
    private static final String CHARACTERS_PATTERN = "^[a-zA-Z ]*$";
    private static final int MINIMUM_SIZE = 4;
    private static final int MAXIMUM_SIZE = 16;
    private static final int NAME_MINIMUM_SIZE = 2;
    private static final int NAME_MAXIMUM_SIZE = 20;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    @NotNull(message = "Name is mandatory")
    @Pattern(regexp = CHARACTERS_PATTERN, message = "Name must contain only letters and spaces")
    @Size(max = NAME_MAXIMUM_SIZE, min = NAME_MINIMUM_SIZE, message = "Name must be between 2 and 20 characters long")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Last Name is mandatory")
    @Pattern(regexp = CHARACTERS_PATTERN, message = "Last Name must contain only letters and spaces")
    @Size(max = NAME_MAXIMUM_SIZE, min = NAME_MINIMUM_SIZE, message = "Last Name must be between 2 and 20 characters long")
    private String surname;

    @Column(nullable = false)
    @NotNull(message = "Username is mandatory")
    @Pattern(regexp = USERNAME_PATTERN, message = "Username must contain letters and digits")
    @Size(max = MAXIMUM_SIZE, min = MINIMUM_SIZE, message = "Username must be between 4 and 16 characters long")
    private String username;

    @Column(nullable = false)
    @NotNull(message = "Password is mandatory")
    @Pattern(regexp = PASSWORD_PATTERN, message = "Accepted characters are letters, digits and special symbols (@!#$)")
    @Size(max = MAXIMUM_SIZE, min = MINIMUM_SIZE, message = "Password must be between 4 and 16 characters long")
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