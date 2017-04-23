package com.agile.controllers.admin;


import com.agile.handlers.WebAppConfigHandler;
import com.agile.model.Role;
import com.agile.model.User;
import com.agile.repositories.RoleRepository;
import com.agile.resources.UserSaveData;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_UPDATE_USER_URI_PARAM;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_USERS_URI_PARAM;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.LOGOUT_URI_PARAM;
import static com.agile.resources.UriPaths.*;

@Controller
public class UserFormController {

    @Autowired
    private WebAppConfigHandler webConfHandler;

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = ADMIN_DELETE_USER_ID_URI)
    public String delete(@PathVariable(value="id") Integer id) {
        userService.deleteUser(id);
        return REDIRECT_ADMIN_USERS_URI;
    }

    @GetMapping(value = ADMIN_CREATE_USER_URI)
    public ModelAndView create() {
        List<Role> roles = roleRepository.findAll();
        ModelAndView modelAndView = getModelAndView("user_form");
        modelAndView.addObject("url", ADMIN_CREATE_USER_URI);
        modelAndView.addObject("roles", roles);
        return modelAndView;
    }

    @PostMapping(value = ADMIN_CREATE_USER_URI)
    public ModelAndView save(@Valid @ModelAttribute("user") UserSaveData userData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Role> roles = roleRepository.findAll();
            ModelAndView modelAndView = getModelAndView("user_form");
            modelAndView.addObject("url", ADMIN_CREATE_USER_URI);
            modelAndView.addObject("user", userData);
            modelAndView.addObject("roles", roles);
            //To-Do: Do something with errors
            return modelAndView;
        }
        userService.createUser(userData);
        return getModelAndView(REDIRECT_ADMIN_USERS_URI);
    }

    @GetMapping(value = ADMIN_UPDATE_USER_ID_URI)
    public ModelAndView edit(@PathVariable(value="id") Integer id) {
        UserSaveData userUpdateData = new UserSaveData(userService.getUser(id));
        List<Role> roles = roleRepository.findAll();
        ModelAndView modelAndView = getModelAndView("user_form");
        modelAndView.addObject("user", userUpdateData);
        modelAndView.addObject("roles", roles);
        modelAndView.addObject("url", webConfHandler.getWebAppPath(ADMIN_UPDATE_USER_URI_PARAM));
        return modelAndView;
    }

    @PostMapping(value = ADMIN_UPDATE_USER_URI)
    public ModelAndView change(@Valid @ModelAttribute("user") UserSaveData userData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Role> roles = roleRepository.findAll();
            ModelAndView modelAndView = getModelAndView("user_form");
            modelAndView.addObject("url", webConfHandler.getWebAppPath(ADMIN_UPDATE_USER_URI_PARAM));
            modelAndView.addObject("user", userData);
            modelAndView.addObject("roles", roles);
            //To-Do: Do something with errors
            return modelAndView;
        }
        userService.updateUserByAdmin(userData);
        return getModelAndView(REDIRECT_ADMIN_USERS_URI);
    }

    private ModelAndView getModelAndView(String viewName) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(ADMIN_UPDATE_USER_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_UPDATE_USER_URI_PARAM));
        modelAndView.addObject(ADMIN_USERS_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(ADMIN_USERS_URI_PARAM));
        modelAndView.addObject(LOGOUT_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(LOGOUT_URI_PARAM));
        return modelAndView;
    }
}
