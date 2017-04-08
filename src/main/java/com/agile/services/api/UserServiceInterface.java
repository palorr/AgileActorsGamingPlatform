package com.agile.services.api;

import com.agile.model.User;

import java.util.List;

public interface UserServiceInterface {

    void saveUser(User user);
    List<User> fetchUsers();
    User getUserByUserNameAndPassword(String username, String password);
}
