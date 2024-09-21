package com.ahtcoffee.crudcoffee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ahtcoffee.crudcoffee.models.Coffee;

@Service
public class CoffeeService {
    private List<Coffee> coffees = new ArrayList<>();
    
    public List<Coffee> getAllCoffee() {
        return coffees;
    }

    public void addCoffee(Coffee coffee) {
        this.coffees.add(coffee);
    }

    public Coffee getCoffeeById(Integer code) {
        for (Coffee cff : coffees) {
            if (cff.getCode().equals(code)) {
                return cff;
            }
        }
        return null;
    }

    public void setCoffee(Coffee kopi, Integer code) {
        Coffee coffee = getCoffeeById(code);
        if (coffee != null) {
            coffee.setCode(kopi.getCode());
            coffee.setMerk(kopi.getMerk());
            coffee.setPrice(kopi.getPrice());
            coffee.setType(kopi.getType());
        }
    }

    public void deleteCoffee(Integer code) {
        for (int i = 0; i < coffees.size(); i++) {
            if (coffees.get(i).getCode() == code) {
                coffees.remove(i);
            }
        }
    }

}
