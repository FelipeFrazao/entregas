package com.entregas.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="users")
@Builder
@Data
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

}
