package com.agile.controllers.admin;


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

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserFormController {

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

    @GetMapping(value = "/admin/users/{id}/edit")
    public String edit(@PathVariable(value="id") Integer id, Model model) {
        User user = userService.getUser(id);
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        model.addAttribute("url", "/admin/users/" + id + "/edit");
        return "user_form";
    }

    @PostMapping(value = "/admin/users/{id}/edit")
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
}
