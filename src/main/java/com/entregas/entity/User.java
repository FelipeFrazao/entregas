package com.entregas.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="users")
@Builder
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String cpf;
}
