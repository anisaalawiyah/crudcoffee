package com.ahtcoffee.crudcoffee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahtcoffee.crudcoffee.models.Coffee;
import com.ahtcoffee.crudcoffee.reporitories.CoffeeRepository;

@Controller
public class CoffeeController {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping("/search")
    public String SearchByname(@RequestParam(name="search") String merk ,Model model){
        List<Coffee>coffees= coffeeRepository.findByMerkContainingIgnoreCase(merk);
        model.addAttribute("coffees", coffees);
        return "list-coffee";
    }

    @GetMapping("/sort-by-merk-asc")
    public String SortByMerk(Model model){
        List<Coffee> coffees= coffeeRepository.findAllByOrderByMerkAsc();
        model.addAttribute("coffees", coffees);
        return "list-coffee";
    }


    @GetMapping("/list-coffee")
    public String listCoffee(Model model) {
        List<Coffee> Coffees = coffeeRepository.findAll();
        model.addAttribute("cofees", Coffees);
        // model.addAttribute("coffees", coffeeRepository.findAll());
        return "list-coffee";
    }

    @GetMapping("/add")
    public String addCoffee(Model model) {
        Coffee coffee = new Coffee();
        model.addAttribute("coffee", coffee);
        return "add-coffee";
    }

    @PostMapping("/add-save")
    public String saveCoffee(Coffee coffee) {
        coffeeRepository.save(coffee);
        return "redirect:/list-coffee";
    }

    @PostMapping("/updates/{code}")
    public String saveUpdate(@ModelAttribute("coffee") Coffee coffee, @PathVariable Integer code) {
        coffeeRepository.save(coffee);
        return "redirect:/list-coffee";
    }

    @GetMapping("/update/{code}")
    public String updateCoffee(Model model, @PathVariable Integer code) {
        Coffee coffee = coffeeRepository.getReferenceById(code);
        model.addAttribute("coffee", coffee);
        return "update-coffee";
    }

    @GetMapping("/delete/{code}")
    public String deleteCoffee(@PathVariable(value = "code") Integer code) {
        coffeeRepository.deleteById(code);;
        return "redirect:/list-coffee";
    }
    

}
