package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.model.UserSaveData;
import com.agile.repositories.UserRepository;
import com.agile.services.api.UserServiceInterface;
import com.agile.validator.UserUpdateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.LOGOUT_URI_PARAM;

@Controller
public class UserFormUpdateController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private UserUpdateFormValidator userUpdateFormValidator;

    @Autowired
    private WebAppConfigHandler webAppConfigHandler;

    @InitBinder("userUpdateData")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userUpdateFormValidator);
    }


    @GetMapping(value = "/admin/update_user/{id}")
    public ModelAndView loadUserEditForm(@PathVariable(value="id") Integer id) {
        UserSaveData userUpdateData = new UserSaveData(userRepository.findOne(id));
        ModelAndView modelAndView = new ModelAndView("user_update_form");
        modelAndView.addObject("userUpdateData", userUpdateData);
        modelAndView.addObject(LOGOUT_URI_PARAM.getWebConfigParam(),
                webAppConfigHandler.getWebAppPath(LOGOUT_URI_PARAM));
        return modelAndView;
    }

    @PostMapping(value = "/admin/update_user/")
    public ModelAndView handleUserEditOperation(@Valid @ModelAttribute("userUpdateData") UserSaveData userUpdateData,
                                                BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView("user_update_form");
        modelAndView.addObject("userUpdateData", userUpdateData);
        modelAndView.addObject(LOGOUT_URI_PARAM.getWebConfigParam(),
                webAppConfigHandler.getWebAppPath(LOGOUT_URI_PARAM));

        if (bindingResult.hasErrors()) {
            modelAndView.addObject("errors", bindingResult.getAllErrors());
            return modelAndView;
        }

        userService.updateUser(userUpdateData);

        modelAndView = new ModelAndView("redirect:/admin/users/");
        modelAndView.addObject(LOGOUT_URI_PARAM.getWebConfigParam(),
                webAppConfigHandler.getWebAppPath(LOGOUT_URI_PARAM));

        return modelAndView;
    }
}
