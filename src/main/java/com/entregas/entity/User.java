package com.entregas.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name="users")
@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;
    private String email;
    private String password;
    private String phone;
    private String cpf;
    private int type = 0;
    private boolean isActive = true;

}
