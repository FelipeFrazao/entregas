package com.entregas.controllers;

import com.entregas.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import com.entregas.services.UserService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
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

    @GetMapping(LOGIN_URI)
    public ModelAndView login(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();
        Cookie[] cookies = request.getCookies();
        Cookie userId;
        if (cookies != null) {
            userId = Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals("userId"))
                    .findAny()
                    .orElse(null);
            if (userId != null) {
                modelAndView.addObject("id", Long.valueOf(userId.getValue()));
                modelAndView.setViewName("redirect:" + PROFILE_URI + userId);
                return modelAndView;
            }
        }
        modelAndView.setViewName("login");
        modelAndView.addObject("user", User.builder().build());
        return modelAndView;
    }

    @PostMapping(value = LOGIN_URI, consumes =  MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ModelAndView loginPost(@RequestBody MultiValueMap<String, String> params, BindingResult result, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        String email = params.getFirst("email");
        String password = params.getFirst("password");
        User user = userService.findUserByEmailPassword(email, password);
        if (user != null) {
            Cookie cookie = new Cookie("userId", String.valueOf(user.getId()));
            cookie.setMaxAge(3 * 60 * 60);
            response.addCookie(cookie);
            if (user.getType() == 0) {
                ModelAndView mv = new ModelAndView("redirect:" + PROFILE_URI);
                mv.addObject("user", user);
                mv.addObject("id", user.getId());
                return mv;
            }
            modelAndView.addObject("name", user.getName());
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        modelAndView = new ModelAndView("redirect:" + LOGIN_URI);
        return modelAndView;

    }

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
        log.info(params.get("name").get(0));

        if (result.hasErrors()) {
            log.error(result.getAllErrors().get(0).getObjectName());
            return new ModelAndView(HELLO_URI);
        }
        User user = User.builder().name(params.get("name").get(0))
                .email(params.get("email").get(0))
                .cpf(params.get("cpf").get(0))
                .password(params.get("password").get(0))
                .phone(params.get("phone").get(0))
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

        ModelAndView modelAndView = new ModelAndView("redirect:" + PROFILE_URI);
        log.info(params.get("name").toString());

        if (result.hasErrors()) {
            log.error(result.getAllErrors().get(0).getObjectName());
            return new ModelAndView(EDIT_URI);
        }
        User user = User.builder().name(params.get("name").get(0))
                .email(params.get("email").get(0))
                .password(params.get("password").get(0))
                .cpf(params.get("cpf").get(0))
                .phone(params.get("phone").get(0))
                .build();
        boolean isAdded = userService.saveUser(user);
        if (isAdded) {
            modelAndView.addObject("name", user.getName());
            modelAndView.addObject("message", "New user successfully added");
            log.info("User added: {}", user.getName());
        } else {
            log.error(result.getAllErrors().get(0).getObjectName());
            return new ModelAndView(EDIT_URI);
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
