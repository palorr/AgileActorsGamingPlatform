package com.agile.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.agile.models.User;
import com.agile.repositories.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping(value = "/users")
	public List<User> users() {
		List<User> users = userRepository.findAll();
		return users;
	}

	@GetMapping(value = "/users/{id}")
	public User userDetails(@PathVariable(value = "id") Integer id) {
		User user = userRepository.findOne(id);
		return user;
	}

}
