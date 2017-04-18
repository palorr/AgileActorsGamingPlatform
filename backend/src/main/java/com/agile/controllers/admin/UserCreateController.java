package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.resources.UserSaveData;
import com.agile.services.api.UserServiceInterface;
import com.agile.validator.UserCreateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.LOGOUT_URI_PARAM;

@Controller
public class UserCreateController {

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private UserCreateFormValidator userCreateFormValidator;

    @Autowired
    private WebAppConfigHandler webConfHandler;

    @InitBinder("userCreateData")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @GetMapping(value = "/admin/create_user")
    public ModelAndView loadUserCreateForm() {
        ModelAndView modelAndView = getModelAndView("user_create_form");
        modelAndView.addObject("userCreateData", new UserSaveData());
        return modelAndView;
    }

    @PostMapping(value = "/admin/create_user")
    public ModelAndView handleUserCreateOperation(@Valid @ModelAttribute("userCreateData") UserSaveData userCreateData,
                                             BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = getModelAndView("user_create_form");
            modelAndView.addObject("userCreateData", userCreateData);
            modelAndView.addObject("errors", bindingResult.getAllErrors());
            return modelAndView;
        }

        userService.createUser(userCreateData);
        return getModelAndView("redirect:/admin/users/");
    }

    private ModelAndView getModelAndView(String viewName) {
        ModelAndView modelAndView = new ModelAndView(viewName);
        modelAndView.addObject(LOGOUT_URI_PARAM.getParam(),
                webConfHandler.getWebAppPath(LOGOUT_URI_PARAM));
        return modelAndView;
    }
}
