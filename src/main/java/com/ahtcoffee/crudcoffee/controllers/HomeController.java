package com.ahtcoffee.crudcoffee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ahtcoffee.crudcoffee.reporitories.SalesRepository;

@Controller
public class HomeController {
    @Autowired
    private SalesRepository salesRepository;


    @GetMapping("home")
    public String home(Model model){
        model.addAttribute("sales", salesRepository.findAll());
        return "home";
    }

}
