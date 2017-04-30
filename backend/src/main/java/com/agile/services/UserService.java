package com.agile.services;

import com.agile.model.Role;
import com.agile.model.User;
import com.agile.repositories.UserRepository;
import com.agile.resources.*;
import com.agile.model.Wallet;
import com.agile.repositories.*;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service("userService")
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private WalletRepository walletRepo;

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
    public List<User> fetchUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public DummyLoginResponse getUserByUsernameAndPassword( CredentialsToLogin credentials) {

        String username = credentials.getUsername();
        String password = credentials.getPassword();

        DummyLoginResponse response = new DummyLoginResponse(0);
        User user = userRepository.findByUsername(username);

        if(user != null){

            if(passwordEncoder.matches(password,user.getPassword())){
                response.setId(user.getId());
            }
        }
        return response;
    }

    @Override
    @Transactional
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
	public UserResource getUserBasicInfoById(int id) {
		User user = userRepository.findById(id);
		UserResource resource = new UserResource();
		resource.setId(id);
		resource.setName(user.getName());
		resource.setSurname(user.getSurname());
		resource.setUsername(user.getUsername());
		resource.setAvatar(user.getAvatar());

		return resource;
	}

    @Override
    @Transactional
    public void updateUser(String surname, String name, int id, String avatar, String username) {
        User user = userRepository.findById(id);
        user.setAvatar(avatar);
        user.setName(name);
        user.setSurname(surname);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(UserResource resource) {
        User user = userRepository.findById(resource.getId());
        user.setAvatar(resource.getAvatar());
        user.setName(resource.getName());
        user.setSurname(resource.getSurname());
        user.setUsername(resource.getUsername());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public User createUser(UserSaveData userData, Wallet wallet) {

        if (wallet == null){
            wallet = new Wallet();
            walletRepo.save(wallet);
        }

        User user = new User(userData.getName(), userData.getSurname(),
                userData.getUsername(), passwordEncoder.encode(userData.getPassword()),
                userData.getRole(), wallet);
        if (userData.getAvatar() != null) {
            user.setAvatar(userData.getAvatar());
        }

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public RegisterResponse registerUserFromRest(UserToRegister userToRegister){

        RegisterResponse registerResponse = new RegisterResponse(false) ;

        if(userToRegister.areBothPasswordsTheSame()){
            if(userRepository.findByUsername(userToRegister.getUsername()) == null){ //if username does not exists

                Wallet wallet = new Wallet();
                walletRepo.save(wallet);

                Role userRole = roleRepository.findByName("USER");
                User user = new User(userToRegister.getName(),userToRegister.getSurname(), userToRegister.getUsername() , passwordEncoder.encode(userToRegister.getPassword()) ,userRole ,wallet);
                userRepository.save(user);
                registerResponse.setSuccess(true);
                return registerResponse;
            }
        }
        return registerResponse;
    }

    @Override
    @Transactional
    public User updateUserByAdmin(UserSaveData userData) {
        User user = userRepository.findOne(userData.getId());
        //user.setAvatar(userData.getAvatar());
        user.setName(userData.getName());
        user.setSurname(userData.getSurname());
        user.setPassword(passwordEncoder.encode(userData.getPassword()));
        user.setUsername(userData.getUsername());
        user.setRole(userData.getRole());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userCreditsOperationsRepo.deleteByUserId(id);
        userGamePlayOperationRepo.deleteByUserId(id);
        adminViewOperationRepo.deleteByUserId(id);
        userGameBuyOperationRepo.deleteByUserId(id);
        updatedGamesRepo.deleteByUserId(id);
        userRepository.delete(id);
    }

    @Override
    public User getUser(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findUserById(int id) {
		return userRepository.findById(id);
	}

    @Override
    public User getUserByUserNameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

    @Transactional
	public void saveUser(User user) {
		userRepository.save(user);
	}

    @Override
    @Transactional
	public List<UserResource> getBasicInfoOfAllUsersWithNameStartsWith(String searchTerm){
		List<UserResource> usersWithSearchCriteria = userRepository.findByNameStartingWithOrSurnameStartingWithOrUsernameStartingWith(searchTerm, searchTerm, searchTerm).stream().map(user -> {

			UserResource resource = new UserResource();
			resource.setId(user.getId());
			resource.setName(user.getName());
			resource.setUsername(user.getUsername());
			resource.setSurname(user.getSurname());
			resource.setAvatar(user.getAvatar());
			return resource;
		}).collect(Collectors.toList());

		return usersWithSearchCriteria;
	}

    @Override
    @Transactional
	public List<UserResource> getBasicInfoOfAllUsers() {
		List<UserResource> usersToReturn = userRepository.findAll().stream().map(user -> {

			UserResource resource = new UserResource();
			resource.setId(user.getId());
			resource.setName(user.getName());
			resource.setUsername(user.getUsername());
			resource.setSurname(user.getSurname());
			resource.setAvatar(user.getAvatar());

			return resource;

		}).collect(Collectors.toList());

		return usersToReturn;
	}
}
