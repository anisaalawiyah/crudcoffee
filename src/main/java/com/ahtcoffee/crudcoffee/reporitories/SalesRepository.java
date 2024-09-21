package com.ahtcoffee.crudcoffee.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahtcoffee.crudcoffee.models.Sales;

public interface  SalesRepository extends JpaRepository<Sales, Integer> {
    
}
