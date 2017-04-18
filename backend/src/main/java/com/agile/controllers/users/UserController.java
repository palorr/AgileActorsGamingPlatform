package com.agile.controllers.users;

import java.util.List;
import java.util.Map;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.agile.model.User;
import org.springframework.web.servlet.ModelAndView;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_USERS_URI_PARAM;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.LOGOUT_URI_PARAM;


@RestController
public class UserController {

	@Autowired
	private UserServiceInterface userService;

	@Autowired
	private WebAppConfigHandler webConfHandler;

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
		return userService.getUserByUsernameAndPassword(username, password);
	}

	@GetMapping(value = "/userByUsername/{username}")
	public ModelAndView getUserByUsername(@PathVariable(value = "username") String username) {
		User user = userService.getUserByUsername(username);
		ModelAndView modelAndView = new ModelAndView("user_details", "user", user);
		modelAndView.addObject(ADMIN_USERS_URI_PARAM.getParam(),
				webConfHandler.getWebAppPath(ADMIN_USERS_URI_PARAM));
		modelAndView.addObject(LOGOUT_URI_PARAM.getParam(),
				webConfHandler.getWebAppPath(LOGOUT_URI_PARAM));
		return modelAndView;
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
