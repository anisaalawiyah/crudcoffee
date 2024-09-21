package com.ahtcoffee.crudcoffee.reporitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahtcoffee.crudcoffee.models.Coffee;

public interface CoffeeRepository  extends JpaRepository<Coffee, Integer>{
    List<Coffee> findByMerkContainingIgnoreCase(String merk);
    List<Coffee> findAllByOrderByMerkAsc();
    List<Coffee> findAllByOrderByMerkDesc();

    
}
