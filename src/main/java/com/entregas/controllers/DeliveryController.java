package com.entregas.controllers;

import com.entregas.services.DeliveryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class DeliveryController {

    private DeliveryService deliveryService;

    public DeliveryController () {}

    public DeliveryController (DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }


}
