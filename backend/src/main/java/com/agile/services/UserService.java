package com.agile.services;

import com.agile.model.Game;
import com.agile.model.User;
import com.agile.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserService{

    @Autowired
    private UserRepository userRepo;

    @Transactional
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Transactional
    public List<Map<String, Object>> getBasicInfoOfAllUsers() {

        Map<String , Object> map ;
        List<User> users =  userRepo.findAll() ;
        List<Map<String , Object>> usersToReturn = new ArrayList<>() ;

        for( User user : users){

            map= new HashMap<>();

            map.put("id",user.getId());
            map.put("name",user.getName());
            map.put("surname",user.getSurname());
            map.put("username",user.getUsername());
            map.put("avatar", user.getAvatar());

            usersToReturn.add(map);
        }

        return usersToReturn ;
    }

    @Transactional
    public User getUserByUserNameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }

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

    @Transactional
    public void updateUser(String surname , String name , int id , String avatar , String username){
        User user = userRepo.findById(id);
        user.setAvatar(avatar);
        user.setName(name);
        user.setSurname(surname);
        user.setUsername(username);
        userRepo.save(user);
    }
    
    public User findUserById(int id){
    	return userRepo.findById(id);
    }
}
