package com.agile.controllers.admin;


import com.agile.handlers.WebAppConfigHandler;
import com.agile.model.Role;
import com.agile.model.User;
import com.agile.repositories.RoleRepository;
import com.agile.resources.UserSaveData;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_UPDATE_USER_URI_PARAM;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_USERS_URI_PARAM;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.LOGOUT_URI_PARAM;
import static com.agile.resources.UriPaths.ADMIN_UPDATE_USER_ID_URI;

@Controller
public class UserFormController {

    @Autowired
    private WebAppConfigHandler webConfHandler;

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "/admin/users/{id}/delete")
    public String delete(@PathVariable(value="id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    @GetMapping(value = "/admin/users/create")
    public String create(Model model) {
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("url", "/admin/users/create");
        model.addAttribute("roles", roles);
        return "user_form";
    }

    @PostMapping(value = "/admin/users/create")
    public String save(Model model, @Valid @ModelAttribute("user") UserSaveData userData,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Role> roles = roleRepository.findAll();
            model.addAttribute("url", "/admin/users/create");
            model.addAttribute("user", userData);
            model.addAttribute("roles", roles);
            //To-Do: Do something with errors
            return "user_form";
        }
        userService.createUser(userData);
        return "redirect:/admin/users";
    }

    @GetMapping(value = ADMIN_UPDATE_USER_ID_URI)
    public ModelAndView edit(@PathVariable(value="id") Integer id) {
        UserSaveData userUpdateData = new UserSaveData(userService.getUser(id));
        List<Role> roles = roleRepository.findAll();
        ModelAndView modelAndView = getModelAndView("user_form");
        modelAndView.addObject("user", userUpdateData);
        modelAndView.addObject("roles", roles);
        modelAndView.addObject("url", ADMIN_UPDATE_USER_ID_URI);
        return modelAndView;
    }

    @PostMapping(value = ADMIN_UPDATE_USER_ID_URI)
    public String change(@PathVariable(value="id") Integer id, Model model, @Valid @ModelAttribute("user") UserSaveData userData,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<Role> roles = roleRepository.findAll();
            model.addAttribute("url", "/admin/users/" + id + "/edit");
            model.addAttribute("user", userData);
            model.addAttribute("roles", roles);
            //To-Do: Do something with errors
            return "user_form";
        }
        userService.updateUserByAdmin(userData);
        return "redirect:/admin/users";
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
