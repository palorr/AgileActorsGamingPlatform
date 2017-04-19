package com.agile.services;

import com.agile.model.User;
import com.agile.repositories.UserRepository;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    @Transactional
    public Map<String, Object> getUserBasicInfoById(int id){
        User user =  userRepo.findById(id);
        Map<String, Object> map = new HashMap<String , Object>();

        map.put("id",user.getId());
        map.put("name",user.getName());
        map.put("surname",user.getSurname());
        map.put("username",user.getUsername());
        map.put("avatar", user.getAvatar());
        return map ;
    }

    @Override
    @Transactional
    public void updateUser(String surname , String name , int id , String avatar , String username){
        User user = userRepo.findById(id);
        user.setAvatar(avatar);
        user.setName(name);
        user.setSurname(surname);
        userRepo.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id){
        userRepo.delete(id);
    }

    @Override
    @Transactional
    public User getUser(int id){
        return userRepo.findOne(id);
    }

    public void updateAdminUser(User user){
        User existingUser = userRepo.findById(user.getId());
        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        userRepo.save(user);
    }
}
