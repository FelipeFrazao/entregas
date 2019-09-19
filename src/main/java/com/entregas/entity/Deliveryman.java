package com.entregas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="deliveryman")
@Data
public class Deliveryman extends User {

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "client_deliveries", joinColumns = @JoinColumn(name="deliveryman_id"), inverseJoinColumns=@JoinColumn(name="delivery_id"))
    private Collection<Delivery> deliveries=new ArrayList<>();
    private Double rate;
}
