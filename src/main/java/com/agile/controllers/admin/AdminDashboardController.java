package com.agile.controllers.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminDashboardController {
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String dashboard(ModelMap model) {
        return "dashboard";
    }
}