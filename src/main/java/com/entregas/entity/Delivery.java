package com.entregas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="deliveries")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="senderAddress")
    private String senderAddress;
    private String sender;
    private String status;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    private Double price;
    @ManyToOne
    @JoinColumn(name="deliveryman_id")
    private Deliveryman deliveryman;
    private int category;
    private Double distance;
    @OneToMany
    @JoinTable(name="delivery_payloads", joinColumns=@JoinColumn(name="paylod_ids"), inverseJoinColumns=@JoinColumn(name="delivery_id"))
    private Collection<Payload> payloads = new ArrayList<>();

}
