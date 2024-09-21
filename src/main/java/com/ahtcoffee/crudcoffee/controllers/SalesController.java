package com.ahtcoffee.crudcoffee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.ahtcoffee.crudcoffee.models.Sales;
import com.ahtcoffee.crudcoffee.reporitories.BaristaRepository;
import com.ahtcoffee.crudcoffee.reporitories.CoffeeRepository;
import com.ahtcoffee.crudcoffee.reporitories.SalesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SalesController {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private BaristaRepository baristaRepository;

    @Autowired
    private SalesRepository salesRepository;

    @GetMapping("sales")
    public String showSales(Model model) {
        model.addAttribute("sales", salesRepository.findAll());
        return "show-sales";
    }

    
    @GetMapping("add-sales")
    public String addSales(Model model) {
        Sales sales = new Sales();
        model.addAttribute("sales", sales);
        model.addAttribute("kopi", coffeeRepository.findAll());
        model.addAttribute("baris", baristaRepository.findAll());
        return "save-sales";
    }

    @PostMapping("save-sales")
    public String saveSale(Sales sales) {
        salesRepository.save(sales);
        return "redirect:/sales";
    }

    @GetMapping("/update-sales/{id}")
    public String updateSales(@PathVariable Integer id, Model model) {
        Sales sales = salesRepository.getReferenceById(id);
        model.addAttribute("sales", sales);
        model.addAttribute("cf", coffeeRepository.findAll());
        model.addAttribute("bs", baristaRepository.findAll());
        return "update-sales";
    }

    @PostMapping("/update-sales")
    public String updateSales(@ModelAttribute("sales") Sales updatedSales) {
        // Mendapatkan ID coffee dan barista dari entitas Sales yang ada di basis data
        // Integer coffeeId = updatedSales.getCodeCoffe().getCode();
        // Integer baristaId = updatedSales.getIdBarista().getId();

        // Mengambil entitas Coffee dan Barista terkait dari basis data
        // Coffee coffee = coffeeRepository.findById(coffeeId).orElse(null);
        // Barista barista = baristaRepository.findById(baristaId).orElse(null);

        // Mengatur entitas Coffee dan Barista ke entitas Sales yang diperbarui
        // updatedSales.setCodeCoffe(coffee);
        // updatedSales.setIdBarista(barista);

        // Menyimpan perubahan ke basis data
        salesRepository.save(updatedSales);

        return "redirect:/sales";
    }

    @GetMapping("delete-sales/{id}")
    public String delete(@PathVariable Integer id){
        salesRepository.deleteById(id);
        return "redirect:/sales";
    }
}
