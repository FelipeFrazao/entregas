<<<<<<< HEAD:src/main/java/com/entregas/controllers/HelloWorldController.java
package com.entregas.controllers;
=======
package com.entregas.entregas;
>>>>>>> parent of 7e11d84... Versao inicial configurada com jsp nas views:src/main/java/com/entregas/HelloWorldController.java

import com.entregas.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.entregas.components.UrlBuilder.*;

@Slf4j
@Controller
public class HelloWorldController {

    @GetMapping(INDEX_URI)
    public ModelAndView welcomePage() {
        log.info("Index page");
        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        return model;
    }

    @GetMapping(HELLO_URI)
    public ModelAndView sayHello(@PathVariable String name) {
        log.info("Hello page for person named {}", name);
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject(name);
        return modelAndView;
    }

    @GetMapping(HELLO_USER_URI)
    public ModelAndView sayHelloUser(@PathVariable String email) {
        log.info("Hello page for person with email {}", email);

        User user = User.builder()
                        .email(email)
                        .build();

        ModelAndView modelAndView = new ModelAndView("helloUser");
        modelAndView.addObject(user);

        return modelAndView;
    }

    @PostMapping(HELLO_USER_OBJECT_URI)
    public ModelAndView sayHelloUserWithObject(@RequestBody User user) {
        log.info("Hello page for person with email {}", user.getEmail());

        ModelAndView modelAndView = new ModelAndView("helloUser");
        modelAndView.addObject(user);

        return modelAndView;
    }
}
