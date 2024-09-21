package com.ahtcoffee.crudcoffee.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahtcoffee.crudcoffee.models.Barista;

//  parameternya integer gara-gara dia primary keynya
public interface BaristaRepository extends JpaRepository<Barista,Integer> {

    
}
