package com.agile.validator;

import com.agile.model.Role;
import com.agile.model.User;
import org.springframework.security.core.authority.AuthorityUtils;

public class LoggednInUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public LoggednInUser(User user) {
        super(user.getUsername(), user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRole().getName().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public int getId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

    @Override
    public String toString() {
        return "CurrentUser{" +
                "user=" + user +
                "} " + super.toString();
    }
}