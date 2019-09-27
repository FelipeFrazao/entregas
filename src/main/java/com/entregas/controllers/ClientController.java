package com.entregas.controllers;

import com.entregas.entity.Client;
import com.entregas.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;

import static com.entregas.components.UrlBuilder.*;
import static com.entregas.components.UrlBuilder.HELLO_URI;

@Slf4j
@Controller
public class ClientController {

    private ClientService clientService;

    public ClientController () {}

    @Autowired
    public ClientController (ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping(PROFILE_URI)
    public ModelAndView profile(@PathVariable Long id, HttpServletRequest request) {

        Client client = (Client) clientService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("client", client);
        Cookie[] cookies = request.getCookies();
        Cookie userId;
        if (cookies != null) {
            userId = Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals("userId"))
                    .findAny()
                    .orElse(null);
            if (userId != null) {
                modelAndView.addObject("id", Long.valueOf(userId.getValue()));
                modelAndView.setViewName("profile");
                return modelAndView;
            }
        }
        modelAndView.setViewName("redirect:" + LOGIN_URI);
        return modelAndView;
    }

    @GetMapping(REGISTER_CLIENT_URI)
    public ModelAndView displayNewUserForm() {
        ModelAndView mv = new ModelAndView("registerClient");
        mv.addObject("headerMessage", "Add Client Details");
        mv.addObject("client", Client.builder().build());
        return mv;
    }

    @PostMapping(value = REGISTER_CLIENT_URI, consumes =  MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ModelAndView saveNewUser(@RequestBody MultiValueMap<String, String> params, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:" + HELLO_URI);
        log.info(params.get("name").get(0));

        if (result.hasErrors()) {
            log.error(result.getAllErrors().get(0).getObjectName());
            return new ModelAndView(HELLO_URI);
        }
        Client client = Client.builder().name(params.get("name").get(0))
                .email(params.get("email").get(0))
                .cpf(params.get("cpf").get(0))
                .password(params.get("password").get(0))
                .phone(params.get("phone").get(0))
                .build();
        boolean isAdded = clientService.save(client, "CLIENT");
        if (isAdded) {
            mv.addObject("message", "New client successfully added");
            mv.addObject("name", client.getName());
            log.info("Client added: {}", client.getId());
        } else {
            log.error(result.getAllErrors().get(0).getObjectName());
            return new ModelAndView(HELLO_URI);
        }

        return mv;
    }
}
