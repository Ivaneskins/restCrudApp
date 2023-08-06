package com.ivaneskins.controller;

import com.ivaneskins.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    private static User user = new User("Ivan", "Ivaneskins@test.ru");

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Hello() {
        return "hello";
    }

    @RequestMapping(value = "/xxx", method = RequestMethod.GET)
    public String XXX() {
        return "xxx";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("xxx", user);
        return modelAndView;
    }
}