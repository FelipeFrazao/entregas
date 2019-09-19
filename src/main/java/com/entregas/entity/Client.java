package com.entregas.entity;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="clients")
@Data
public class Client extends User {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "client_deliveries", joinColumns = @JoinColumn(name="client_id"), inverseJoinColumns=@JoinColumn(name="delivery_id"))
    private Collection<Delivery> deliveries=new ArrayList<>();
    private String defaultAddress;
}
