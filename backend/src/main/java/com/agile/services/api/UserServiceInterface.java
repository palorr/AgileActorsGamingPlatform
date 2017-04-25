package com.agile.services.api;

import com.agile.model.User;
import com.agile.resources.UserResource;
import com.agile.resources.UserSaveData;

import java.util.List;

public interface UserServiceInterface {

    List<User> fetchUsers();
    User getUserByUsernameAndPassword(String username, String password);
    User getUserByUsername(String username);
    void updateUser(String surname , String name , int id , String avatar , String username);
    User createUser(UserSaveData userData);
    void deleteUser(int id);
    User getUser(int id);
    User updateUserByAdmin(UserSaveData userData);
    List<UserResource> getBasicInfoOfAllUsers();
    UserResource getUserBasicInfoById(int id);
    List<UserResource> getBasicInfoOfAllUsersWithNameStartsWith(String searchTerm);
    void updateUser(UserResource resource);
    User findUserById(int id);
}
