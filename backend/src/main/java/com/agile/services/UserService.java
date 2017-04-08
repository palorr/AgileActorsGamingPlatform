package com.agile.services;

import com.agile.model.User;
import com.agile.repositories.UserRepository;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("userService")
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepo;

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    @Transactional
    public List<User> fetchUsers() {
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public User getUserByUserNameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }
}
