package com.infnet.delivery.delivery;

import java.util.ArrayList;

import com.infnet.delivery.client.Client;
import com.infnet.delivery.deliveryman.DeliveryMan;
import com.infnet.delivery.payload.Payload;

import lombok.Data;
@Data
public class Delivery {
    private int id;
    private String senderAddress;
    private String sender;
    private String destiny;
    private String recipient;
    // TODO: definir tipo de status
    private String status;
    private Client client;
    private DeliveryMan deliveryman;
    private float price;
    // TODO: definir tipo de class
    private String category;
    private float distance;
    private ArrayList<Payload> payload;

    public void create() {

    }
    public void edit() {

    }
    public void rate() {

    }
    public void finish() {

    }
    public void calculatePrice() {

    }
    public void addPayload() {

    }
    public void removePayload() {

    }

}