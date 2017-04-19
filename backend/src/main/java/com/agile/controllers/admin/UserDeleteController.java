package com.agile.controllers.admin;

import com.agile.handlers.WebAppConfigHandler;
import com.agile.services.api.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static com.agile.handlers.WebAppConfigHandler.WebAppConfigAttributes.LOGOUT_URI_PARAM;
import static com.agile.resources.UriPaths.ADMIN_DELETE_USER_ID_URI;
import static com.agile.resources.UriPaths.REDIRECT_ADMIN_USERS_URI;

@Controller
public class UserDeleteController {

    @Autowired
    private UserServiceInterface userService;

    @Autowired
    private WebAppConfigHandler webAppConfigHandler;

    @RequestMapping(value = ADMIN_DELETE_USER_ID_URI)
    public ModelAndView handleUserDeleteOperation(@PathVariable(value="id") Integer id) {
        userService.deleteUser(id);
        ModelAndView modelAndView = new ModelAndView(REDIRECT_ADMIN_USERS_URI);
        modelAndView.addObject(LOGOUT_URI_PARAM.getParam(),
                webAppConfigHandler.getWebAppPath(LOGOUT_URI_PARAM));

        return modelAndView;
    }
}
