package com.entregas.controllers;

import com.entregas.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import com.entregas.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.entregas.components.UrlBuilder.*;

@Slf4j
@Controller
public class UserController {

    private UserService userService;

    public UserController() {

    }

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping(value = {"/", "/home"})
//    public String hello() {
//
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("home");
//        return "home";
//    }

    @GetMapping(REGISTER_URI)
    public ModelAndView displayNewUserForm() {
        ModelAndView mv = new ModelAndView("registerUser");
        mv.addObject("headerMessage", "Add User Details");
        mv.addObject("user", User.builder().build());
        return mv;
    }

    @PostMapping(value = REGISTER_URI, consumes =  MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ModelAndView saveNewUser(@RequestBody MultiValueMap<String, String> params, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:" + HELLO_URI);
        log.info(params.get("name").toString());

        if (result.hasErrors()) {
            log.error(result.getAllErrors().get(0).getObjectName());
            return new ModelAndView(HELLO_URI);
        }
        User user = User.builder().name(params.get("name").toString())
                .email(params.get("email").toString())
                .cpf(params.get("cpf").toString())
                .password(params.get("password").toString())
                .phone(params.get("phone").toString())
                .build();
        boolean isAdded = userService.saveUser(user);
        if (isAdded) {
            mv.addObject("message", "New user successfully added");
            mv.addObject("name", user.getName());
            log.info("User added: {}", user.getName());
        } else {
            log.error(result.getAllErrors().get(0).getObjectName());
            return new ModelAndView(HELLO_URI);
        }

        return mv;
    }


    @GetMapping(EDIT_URI)
    public ModelAndView dosplayEditUserForm(@PathVariable Long id) {

        ModelAndView modelAndView = new ModelAndView("/editUser");
        User user = userService.getUserById(id);
        modelAndView.addObject("headerMessage", "Edit User Details");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping(value = EDIT_URI, consumes =  MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ModelAndView updateUser(@RequestBody MultiValueMap<String, String> params, BindingResult result) {

        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        log.info(params.get("name").toString());

        if (result.hasErrors()) {
            log.error(result.getAllErrors().get(0).getObjectName());
            return new ModelAndView(HELLO_URI);
        }
        User user = User.builder().name(params.get("name").toString())
                .email(params.get("email").toString())
                .cpf(params.get("cpf").toString())
                .phone(params.get("phone").toString())
                .password(params.get("password").toString())
                .build();
        boolean isAdded = userService.saveUser(user);
        if (isAdded) {
            modelAndView.addObject("name", user.getName());
            modelAndView.addObject("message", "New user successfully added");
            log.info("User added: {}", user.getName());
        } else {
            log.error(result.getAllErrors().get(0).getObjectName());
            return new ModelAndView(HELLO_URI);
        }
        return modelAndView;
    }

    @GetMapping(USER_URI)
    public ModelAndView viewUsers() {
        ModelAndView mv = new ModelAndView("hello");
        log.info("user uri");
        List userList = userService.getAllUsers();
        log.info(String.valueOf(userList.size()));
        User user = (User) userList.get(0);
        mv.addObject("name", user.getName());
        log.info("User added: {}", user.getName());
        return mv;
    }

}
