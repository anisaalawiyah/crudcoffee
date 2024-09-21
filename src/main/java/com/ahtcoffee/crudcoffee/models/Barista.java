package com.ahtcoffee.crudcoffee.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Barista {
    @Id // di jadiin sebagai primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Integer id;
    private String name;
    private int age;
    private String gender;
    private String email;
    
}
