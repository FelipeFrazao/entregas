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



    @GetMapping(REGISTER_CLIENT_URI)
    public ModelAndView displayNewUserForm() {
        ModelAndView mv = new ModelAndView("registerclient");
        mv.addObject("headerMessage", "Add User Details");
        mv.addObject("client", Client.builder().build());
        return mv;
    }

    @PostMapping(value = REGISTER_CLIENT_URI, consumes =  MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ModelAndView saveNewUser(@RequestBody MultiValueMap<String, String> params, BindingResult result) {
        ModelAndView mv = new ModelAndView("redirect:" + HELLO_URI);
        log.info(params.get("name").toString());

        if (result.hasErrors()) {
            log.error(result.getAllErrors().get(0).getObjectName());
            return new ModelAndView(HELLO_URI);
        }
        Client client = Client.builder().name(params.get("name").toString())
                .email(params.get("email").toString())
                .cpf(params.get("cpf").toString())
                .password(params.get("password").toString())
                .phone(params.get("phone").toString())
                .build();
        boolean isAdded = clientService.save(client, "CLIENT");
        if (isAdded) {
            mv.addObject("message", "New user successfully added");
            mv.addObject("name", client.getName());
            log.info("User added: {}", client.getName());
        } else {
            log.error(result.getAllErrors().get(0).getObjectName());
            return new ModelAndView(HELLO_URI);
        }

        return mv;
    }
}
