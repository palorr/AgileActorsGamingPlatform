package com.agile.services.api;

import com.agile.model.User;
import com.agile.resources.UserSaveData;

import java.util.List;
import java.util.Map;

public interface UserServiceInterface {

    void saveUser(User user);
    List<User> fetchUsers();
    User getUserByUsernameAndPassword(String username, String password);
    Map<String, Object>
    getUserBasicInfoById(int id);
    User getUserByUsername(String username);
    void updateUser(String surname , String name , int id , String avatar , String username);
    User createUser(UserSaveData userData);
    User updateUser(UserSaveData userData);
    void deleteUser(int id);
}
