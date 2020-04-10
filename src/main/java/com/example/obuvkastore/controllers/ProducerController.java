package com.example.obuvkastore.controllers;

import com.example.obuvkastore.entities.Producer;
import com.example.obuvkastore.services.ProducerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProducerController {

    private ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("producers", producerService.getAllProducers());
        return "producer";
    }

    @GetMapping("/add_producer")
    public String addProducer(Model model) {
        model.addAttribute("producer", new Producer());
        return "add_producer";
    }

    @PostMapping("/add_producer")
    public String addProducerSubmit(@Valid Producer producer, BindingResult result) {
        if (result.hasErrors()) {
            return "add_producer";
        } else {
            producerService.saveProducer(producer);
            return "redirect:/";
        }
    }


}
