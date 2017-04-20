package com.agile.services;

import com.agile.model.User;
import com.agile.repositories.UserRepository;
import com.agile.resources.UserResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void saveUser(User user) {
		userRepository.save(user);
	}

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

	@Transactional
	public List<UserResource> getBasicInfoOfAllUsersWithNameStartsWith(String searchTerm){
		List<UserResource> usersWithSearchCriteria = userRepository.findByNameStartingWith(searchTerm).stream().map(user -> {

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

	public User getUserByUserNameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

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

	@Transactional
	public void updateUser(UserResource resource) {
		User user = userRepository.findById(resource.getId());
		user.setAvatar(resource.getAvatar());
		user.setName(resource.getName());
		user.setSurname(resource.getSurname());
		user.setUsername(resource.getUsername());
		userRepository.save(user);
	}

	public User findUserById(int id) {
		return userRepository.findById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}
}
