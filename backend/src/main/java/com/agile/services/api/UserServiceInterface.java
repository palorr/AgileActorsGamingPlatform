package com.agile.services.api;

import com.agile.model.User;
import com.agile.model.Wallet;
import com.agile.resources.*;

import java.util.List;

public interface UserServiceInterface {

    List<User> fetchUsers();
    DummyLoginResponse getUserByUsernameAndPassword(CredentialsToLogin credentials);
    User getUserByUsername(String username);
    void updateUser(String surname , String name , int id , String avatar , String username);
    User createUser(UserSaveData userData, Wallet wallet);
    void deleteUser(int id);
    User getUser(int id);
    User updateUserByAdmin(UserSaveData userData);
    List<UserResource> getBasicInfoOfAllUsers();
    UserResource getUserBasicInfoById(int id);
    List<UserResource> getBasicInfoOfAllUsersWithNameStartsWith(String searchTerm);
    void updateUser(UserResource resource);
    User findUserById(int id);
    User getUserByUserNameAndPassword(String username, String password);
    public RegisterResponse registerUserFromRest(UserToRegister userToRegister);
}
