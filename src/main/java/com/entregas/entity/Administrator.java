package com.entregas.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="administrators")
@Data
public class Administrator extends User {

    private int level;
}
