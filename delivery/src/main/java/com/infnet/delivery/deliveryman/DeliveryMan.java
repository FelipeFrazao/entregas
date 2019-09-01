package com.infnet.delivery.deliveryman;

import java.util.ArrayList;

import com.infnet.delivery.delivery.Delivery;
import com.infnet.delivery.user.User;

import lombok.Data;
@Data
public class DeliveryMan extends User {
    private ArrayList<Delivery> deliveries;
    private float rate;

    public void acceptDelivery() {
        
    }
    public void showDeliveries() {
        
    }

}