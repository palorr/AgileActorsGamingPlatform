package com.agile.controllers;

import java.util.List;

import com.agile.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.agile.models.User;
import com.agile.repositories.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping(value = "/users/{id}")
	public User getUserDetails(@PathVariable(value = "id") Integer id) {
		return userRepository.findOne(id);
	}

	@GetMapping(value = "/users/{name}")
	public List<User> getUserByName(@PathVariable(value = "name") String name) {
		return userRepository.findByName(name);
	}

	/*@GetMapping(value = "/userByName/{name}")
	public User getRoleByUserId(@PathVariable(value = "name") String name) {
		return userRepository.findByNameEquals(name);
	}*/
}
