package com.agile.services.api;

import com.agile.model.User;

import java.util.List;
import java.util.Map;

public interface UserServiceInterface {

    void saveUser(User user);
    List<User> fetchUsers();
    User getUserByUserNameAndPassword(String username, String password);
    Map<String, Object> getUserBasicInfoById(int id);
}
