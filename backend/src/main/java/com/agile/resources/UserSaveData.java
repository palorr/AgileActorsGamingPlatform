package com.agile.resources;

import com.agile.model.Role;
import com.agile.model.User;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserSaveData {

    /* validation rules */
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9]*$";
    private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@!#$]*$";
    private static final String CHARACTERS_PATTERN = "^[a-zA-Z ]*$";
    private static final int MINIMUM_SIZE = 4;
    private static final int MAXIMUM_SIZE = 16;
    private static final int NAME_MINIMUM_SIZE = 2;
    private static final int NAME_MAXIMUM_SIZE = 20;



    public UserSaveData() {}

    public UserSaveData(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.avatar = user.getAvatar();
        this.role = user.getRole();
    }

    @NotEmpty
    @NotNull(message = "Name is mandatory")
    @Pattern(regexp = CHARACTERS_PATTERN, message = "Name must contain only letters and spaces")
    @Size(max = NAME_MAXIMUM_SIZE, min = NAME_MINIMUM_SIZE, message = "Name must be between 2 and 20 characters long")
    private String name;

    @NotEmpty
    @NotNull(message = "Last Name is mandatory")
    @Pattern(regexp = CHARACTERS_PATTERN, message = "Last Name must contain only letters and spaces")
    @Size(max = NAME_MAXIMUM_SIZE, min = NAME_MINIMUM_SIZE, message = "Last Name must be between 2 and 20 characters long")
    private String surname;

    @NotEmpty
    @NotNull(message = "Username is mandatory")
    @Pattern(regexp = USERNAME_PATTERN, message = "Username must contain letters and digits")
    @Size(max = MAXIMUM_SIZE, min = MINIMUM_SIZE, message = "Username must be between 4 and 16 characters long")
    private String username;

    private String avatar;

    @NotEmpty
    @NotNull(message = "Password is mandatory")
    @Pattern(regexp = PASSWORD_PATTERN, message = "Accepted characters are letters, digits and special symbols (@!#$)")
    @Size(max = MAXIMUM_SIZE, min = MINIMUM_SIZE, message = "Password must be between 4 and 16 characters long")
    private String password;

    //private String passwordRepeated;

    private int id;

    @NotEmpty
    private Role role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public String getPasswordRepeated() {
        return passwordRepeated;
    }

    public void setPasswordRepeated(String passwordRepeated) {
        this.passwordRepeated = passwordRepeated;
    }
*/
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
