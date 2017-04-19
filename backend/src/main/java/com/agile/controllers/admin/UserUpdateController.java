package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.repositories.UserRepository;
import com.agile.resources.UserSaveData;
import com.agile.services.api.UserServiceInterface;
import com.agile.validator.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_UPDATE_USER_URI_PARAM;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.ADMIN_USERS_URI_PARAM;
import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.LOGOUT_URI_PARAM;
import static com.agile.resources.UriPaths.ADMIN_UPDATE_USER_ID_URI;

@Controller
public class UserUpdateController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private UserFormValidator userFormValidator;

    @Autowired
    private WebAppConfigHandler webConfHandler;

    @InitBinder("userUpdateData")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userFormValidator);
    }


    @GetMapping(value = ADMIN_UPDATE_USER_ID_URI)
    public ModelAndView loadUserEditForm(@PathVariable(value="id") Integer id) {
        UserSaveData userUpdateData = new UserSaveData(userRepository.findOne(id));
        ModelAndView modelAndView = getModelAndView("user_update_form");
        modelAndView.addObject("userUpdateData", userUpdateData);
        return modelAndView;
    }

    @PostMapping(value = "/admin/update_user/")
    public ModelAndView handleUserEditOperation(@Valid @ModelAttribute("userUpdateData") UserSaveData userUpdateData,
                                                BindingResult bindingResult) {
        String viewName;
        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = getModelAndView("user_update_form");
            modelAndView.addObject("userUpdateData", userUpdateData);
            modelAndView.addObject("errors", bindingResult.getAllErrors());
            return modelAndView;
        }

        userService.updateUser(userUpdateData);
        return getModelAndView("redirect:/admin/users/");
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
