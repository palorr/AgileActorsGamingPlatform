package com.agile.services;

import com.agile.model.User;
import com.agile.resources.UserSaveData;
import com.agile.model.Wallet;
import com.agile.repositories.*;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private WalletRepository walletRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private UserCreditsOperationsRepository userCreditsOperationsRepo;

    @Autowired
    private UserGamePlayOperationRepository userGamePlayOperationRepo;

    @Autowired
    private AdminViewOperationRepository adminViewOperationRepo;

    @Autowired
    private UserGameBuyOperationRepository userGameBuyOperationRepo;

    @Autowired
    private UpdatedGamesRepository updatedGamesRepo;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService() {
    }

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
    public User getUserByUsernameAndPassword(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password);
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    @Transactional
    public Map<String, Object> getUserBasicInfoById(int id) {
        User user = userRepo.findById(id);
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("id", user.getId());
        map.put("name", user.getName());
        map.put("surname", user.getSurname());
        map.put("username", user.getUsername());
        map.put("avatar", user.getAvatar());
        return map;
    }

    @Override
    @Transactional
    public void updateUser(String surname, String name, int id, String avatar, String username) {
        User user = userRepo.findById(id);
        user.setAvatar(avatar);
        user.setName(name);
        user.setSurname(surname);
        userRepo.save(user);
    }

    @Override
    @Transactional
    public User createUser(UserSaveData userData) {
        Wallet wallet = new Wallet();
        walletRepo.save(wallet);

        User user = new User(userData.getName(), userData.getSurname(),
                userData.getUsername(), passwordEncoder.encode(userData.getPassword()),
                roleRepo.findByName(userData.getRole()), wallet);
        if (userData.getAvatar() != null) {
            user.setAvatar(userData.getAvatar());
        }
        return userRepo.save(user);
    }

    @Override
    @Transactional
    public User updateUserByAdmin(UserSaveData userData) {
        User user = userRepo.findOne(userData.getId());
        //user.setAvatar(userData.getAvatar());
        user.setName(userData.getName());
        user.setSurname(userData.getSurname());
        user.setPassword(passwordEncoder.encode(userData.getPassword()));
        user.setUsername(userData.getUsername());
        user.setRole(roleRepo.findByName(userData.getRole()));
        return userRepo.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userCreditsOperationsRepo.deleteByUserId(id);
        userGamePlayOperationRepo.deleteByUserId(id);
        adminViewOperationRepo.deleteByUserId(id);
        userGameBuyOperationRepo.deleteByUserId(id);
        updatedGamesRepo.deleteByUserId(id);
        userRepo.delete(id);
    }
}
