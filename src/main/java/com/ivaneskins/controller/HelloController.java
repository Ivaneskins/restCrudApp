package com.ivaneskins.controller;

import com.ivaneskins.model.User;
import com.ivaneskins.service.UserService;
import com.ivaneskins.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {
    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String Hello() {
//        List<User> usersList = userService.getAllUsers();
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("allUsersView");
//        modelAndView.addObject("allUsers", usersList);
//
//        usersList.stream().forEach(System.out::println);
//        return "allUsersView";
//    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Hello(Model model) {
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("allUsers", usersList);
        return "allUsersView";
    }
}
