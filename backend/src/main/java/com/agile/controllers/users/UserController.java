package com.agile.controllers.users;

import java.util.List;
import com.agile.handlers.WebAppConfigHandler;
import com.agile.resources.*;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.agile.model.User;
import org.springframework.web.servlet.ModelAndView;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.*;


@CrossOrigin(origins = "http://localhost:5555")
@RestController
public class UserController {

	@Autowired
	private UserServiceInterface userService;

	@Autowired
	private WebAppConfigHandler webConfHandler;

	@GetMapping(value = "rest/users")
	public List<UserResource> getBasicInfoOfAllUsers() {
		return userService.getBasicInfoOfAllUsers();
	}

	@GetMapping(value = "rest/users/{id}")
	public UserResource getUserBasicInfoById(@PathVariable(value = "id") int id){
		return userService.getUserBasicInfoById(id);
	}

	@PostMapping(value = "rest/login")
	public DummyLoginResponse getUserByCredentials(@RequestBody CredentialsToLogin credentials) {
		return userService.getUserByUsernameAndPassword(credentials);
	}

	@PostMapping(value = "rest/register")
	public RegisterResponse registerUser(@RequestBody UserToRegister userToRegister) {
		return userService.registerUserFromRest(userToRegister);
	}

	@GetMapping(value = "rest/userByUsername/{username}")
	public ModelAndView getUserByUsername(@PathVariable(value = "username") String username) {
		User user = userService.getUserByUsername(username);
		ModelAndView modelAndView = new ModelAndView("user_details", "user", user);
		modelAndView.addObject(ADMIN_USERS_URI_PARAM.getParam(),
				webConfHandler.getWebAppPath(ADMIN_USERS_URI_PARAM));
		modelAndView.addObject(ADMIN_URI_PARAM.getParam(),
				webConfHandler.getWebAppPath(ADMIN_URI_PARAM));
		modelAndView.addObject(ADMIN_GAMES_URI_PARAM.getParam(),
				webConfHandler.getWebAppPath(ADMIN_GAMES_URI_PARAM));
		modelAndView.addObject(LOGOUT_URI_PARAM.getParam(),
				webConfHandler.getWebAppPath(LOGOUT_URI_PARAM));
		return modelAndView;
	}

    @PutMapping(value = "rest/users/edit")
    public void updateUser(@RequestBody UserResource userResource) {
		userService.updateUser(userResource);
    }

    @GetMapping(value = "rest/users/search/{searchTerm}")
	public List<UserResource> searchUser(@PathVariable(value = "searchTerm") String searchTerm){
		return userService.getBasicInfoOfAllUsersWithNameStartsWith(searchTerm);
	}
}
