package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.model.UserSaveData;
import com.agile.repositories.UserRepository;
import com.agile.services.api.UserServiceInterface;
import com.agile.validator.UserCreateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.LOGOUT_URI_PARAM;

@Controller
public class UserFormCreateController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private UserCreateFormValidator userCreateFormValidator;

    @Autowired
    private WebAppConfigHandler webAppConfigHandler;

    @InitBinder("userCreateData")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }


    @RequestMapping(value = "/admin/users/{id}/delete")
    public String delete(@PathVariable(value="id") Integer id, Model model) {
        userRepository.delete(id);
        return "redirect:/admin/users";
    }

    @GetMapping(value = "/admin/create_user")
    public ModelAndView loadUserCreateForm() {
        ModelAndView modelAndView = new ModelAndView("user_create_form");
        modelAndView.addObject("userCreateData", new UserSaveData());
        modelAndView.addObject(LOGOUT_URI_PARAM.getWebConfigParam(),
                webAppConfigHandler.getWebAppPath(LOGOUT_URI_PARAM));
        return modelAndView;
    }

    @PostMapping(value = "/admin/create_user")
    public ModelAndView handleUserCreateOperation(@Valid @ModelAttribute("userCreateData") UserSaveData userCreateData,
                                             BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("user_create_form");
        modelAndView.addObject("userCreateData", new UserSaveData());
        modelAndView.addObject(LOGOUT_URI_PARAM.getWebConfigParam(),
                webAppConfigHandler.getWebAppPath(LOGOUT_URI_PARAM));

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("errors", bindingResult.getAllErrors());
            return modelAndView;
        }

        userService.createUser(userCreateData);

        modelAndView = new ModelAndView("redirect:/admin/users/");
        modelAndView.addObject(LOGOUT_URI_PARAM.getWebConfigParam(),
                webAppConfigHandler.getWebAppPath(LOGOUT_URI_PARAM));

        return modelAndView;
    }
}
