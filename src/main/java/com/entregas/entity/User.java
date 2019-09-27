package com.entregas.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "*Por favor informe seu nome")
    private String name;
    @Email(message = "*Por favor coloque um Email valido")
    @NotEmpty(message = "*Por favor coloque um Email valido")
    private String email;
    @Length(min = 5, message = "*Sua senha deve ter no minimo 5 caracteres")
    private String password;
    private String phone;
    @NotEmpty(message = "*Por favor informe seu cpf")
    private String cpf;
    private int type = 0;
    private boolean isActive = true;

}
