package com.agile.controllers.users;

import java.util.List;
import java.util.Map;

import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.agile.model.User;
import com.agile.repositories.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserServiceInterface userService;

	@GetMapping(value = "/users")
	public List<User> getUsers() {
		return userService.fetchUsers();
	}

	@GetMapping(value = "/users/{id}")
	public Map<String, Object> getUserBaseInfoById(@PathVariable(value = "id") int id){
		return userService.getUserBasicInfoById(id);
	}

	@GetMapping(value = "/userByCredentials/{username}/{password}")
	public User getUserByCredentials(@PathVariable(value = "username") String username,
									 @PathVariable(value = "password") String password) {
		return userService.getUserByUserNameAndPassword(username, password);
	}
}
