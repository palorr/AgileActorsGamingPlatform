package com.agile.controllers.admin;


import com.agile.models.User;
import com.agile.repositories.UserRepository;
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
    private UserRepository userRepository;

    @RequestMapping(value = "/admin/users/{id}/delete")
    public String delete(@PathVariable(value="id") Integer id, Model model) {
        userRepository.delete(id);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users/create", method = RequestMethod.GET)
    public String create(Model model) {
        return "user_form";
    }

    @RequestMapping(value = "/admin/users/create", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/admin/users";
    }
}
