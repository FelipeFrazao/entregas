package com.infnet.delivery.client;

import java.util.ArrayList;

import com.infnet.delivery.delivery.Delivery;
import com.infnet.delivery.user.User;

import lombok.Data;
@Data
public class Client extends User {
    private ArrayList<Delivery> deliveries;
    private String defaultAddress;

    public void orderDelivery() {
        
    }
    public void showDeliveries() {
        
    }
    public void cancelDelivery() {
        
    }

}