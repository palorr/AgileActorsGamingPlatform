package com.agile.controllers.admin;


import com.agile.model.User;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserFormController {

    @Autowired
    private UserServiceInterface userService;

    @RequestMapping(value = "/admin/users/{id}/delete")
    public String delete(@PathVariable(value="id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("url", "/admin/users/create");
        return "user_form";
    }

    @RequestMapping(value = "/admin/users/create", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable(value="id") Integer id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        model.addAttribute("url", "/admin/users/" + id + "/edit");
        return "user_form";
    }

    @RequestMapping(value = "/admin/users/{id}/edit", method = RequestMethod.POST)
    public String change(@ModelAttribute("user") User user) {
        userService.updateAdminUser(user);
        return "redirect:/admin/users";
    }
}
