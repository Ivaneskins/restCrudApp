package com.ivaneskins.controller;

import com.ivaneskins.model.User;
import com.ivaneskins.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Hello(Model model) {
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("allUsers", usersList);
        return "allUsersView";
    }
}
