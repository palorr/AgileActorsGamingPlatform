package com.agile.controllers.users;

import java.util.List;
import com.agile.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import com.agile.model.User;
import com.agile.resources.UserResource;

@CrossOrigin(origins = "http://localhost:5555")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/users")
	public List<UserResource> getBasicInfoOfAllUsers() {
		return userService.getBasicInfoOfAllUsers();
	}

	@GetMapping(value = "/users/{id}")
	public UserResource getUserBasicInfoById(@PathVariable(value = "id") int id){
		return userService.getUserBasicInfoById(id);
	}

//	// TODO: this error "result returns more than one elements" until we set unique data into database (validate username to be unique)
//	@GetMapping(value = "/users")
//	public User getUserByCredentials(@Param(value = "username") String username,
//									 @Param(value = "password") String password) {
//		return userService.getUserByUserNameAndPassword(username, password);
//	}

    @PutMapping(value = "/users/edit")
    public void updateUser(@RequestBody UserResource userResource) {
		userService.updateUser(userResource);
    }
}
