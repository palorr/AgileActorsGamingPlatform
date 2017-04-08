package com.agile.controllers.admin;


import com.agile.model.User;
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
        model.addAttribute("url", "/admin/users/create");
        return "user_form";
    }

    @RequestMapping(value = "/admin/users/create", method = RequestMethod.POST)
    public String save(Model model, @ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable(value="id") Integer id, Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("url", "/admin/users/" + id + "/edit");
        return "user_form";
    }

    @RequestMapping(value = "/admin/users/{id}/edit", method = RequestMethod.POST)
    public String change(@ModelAttribute("user") User user, Model model) {
        userRepository.save(user);
        return "redirect:/admin/users";
    }
}
