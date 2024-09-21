package com.ahtcoffee.crudcoffee.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String date;

    @ManyToOne
    @JoinColumn(name="code_coffe",referencedColumnName = "code")
    private Coffee codeCoffe;

    @ManyToOne
    @JoinColumn(name="id_coffe",referencedColumnName = "id")
    private Barista idBarista;
    
}
