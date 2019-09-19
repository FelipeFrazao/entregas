package com.entregas.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="payloads")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payload {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Double height;
    private Double width;
    private Double length;
    private Double weight;
    private int type;
    @ManyToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;


}
