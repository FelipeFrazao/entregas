package com.entregas.controller;

import com.entregas.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.entregas.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController {

    private UserService userService;

    public UserController() {

    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/", "/home"})
    public String hello() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return "home";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView displayNewUserForm() {
        ModelAndView mv = new ModelAndView("createUser");
        mv.addObject("headerMessage", "Add User Details");
        mv.addObject("user", new User());
        return mv;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView saveNewUser(@ModelAttribute User user, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:/home");

        if (result.hasErrors()) {
            return new ModelAndView("error");
        }
        boolean isAdded = userService.saveUser(user);
        if (isAdded) {
            mv.addObject("message", "New user successfully added");
        } else {
            return new ModelAndView("error");
        }

        return mv;
    }

    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
    public ModelAndView dosplayEditUserForm(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView("/editUser");
        User user = userService.getUserById(id);
        modelAndView.addObject("headerMessage", "Edit User Details");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.POST)
    public ModelAndView updateUser(@ModelAttribute User user, BindingResult result) {

        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        if(result.hasErrors()) {
            System.out.println(result.toString());
            return new ModelAndView("error");
        }
        boolean isSaved = userService.saveUser(user);
        if (!isSaved) {

            return new ModelAndView("error");
        }
        return modelAndView;
    }

}
