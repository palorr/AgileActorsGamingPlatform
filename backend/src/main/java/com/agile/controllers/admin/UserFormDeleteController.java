package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.LOGOUT_URI_PARAM;

@Controller
public class UserFormDeleteController {

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private WebAppConfigHandler webAppConfigHandler;

    @RequestMapping(value = "/admin/delete_user/{id}")
    public ModelAndView handleUserDeleteOperation(@PathVariable(value="id") Integer id) {
        userService.deleteUser(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/users/");
        modelAndView.addObject(LOGOUT_URI_PARAM.getWebConfigParam(),
                webAppConfigHandler.getWebAppPath(LOGOUT_URI_PARAM));

        return modelAndView;
    }
}
