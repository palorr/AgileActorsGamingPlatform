package com.agile.controllers.users;

import java.util.List;
import java.util.Map;

import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.agile.model.User;


@RestController
public class UserController {

	@Autowired
	private UserServiceInterface userService;

	@GetMapping(value = "/users")
	public List<Map<String, Object>> getBasicInfoOfAllUsers() {
		List<Map<String, Object>> users = userService.getBasicInfoOfAllUsers();
		return users ;
	}

	@GetMapping(value = "/users/{id}")
	public Map<String, Object> getUserBasicInfoById(@PathVariable(value = "id") int id){
		return userService.getUserBasicInfoById(id);
	}

	@GetMapping(value = "/userByCredentials/{username}/{password}")
	public User getUserByCredentials(@PathVariable(value = "username") String username,
									 @PathVariable(value = "password") String password) {
		return userService.getUserByUserNameAndPassword(username, password);
	}


    @PutMapping(value = "/users/edit")
    @ResponseBody
    public void updateUser(@RequestBody Map<String,Object> user) {
		String surname = (String) user.get("surname");
		String name = (String) user.get("name");

		int id = (int) user.get("id");

		String avatar = (String) user.get("avatar");
		String username = (String) user.get("username");

		userService.updateUser(surname,name,id,avatar,username);

    }



}
