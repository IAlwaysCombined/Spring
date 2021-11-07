package com.example.zaicev.controller;

import com.example.zaicev.model.Adress;
import com.example.zaicev.repo.Address;
import com.example.zaicev.repo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    public Address addressRepository;
    @Autowired
    public Person personRepository;

    @GetMapping("/")
    public String Main(Model model){
        Iterable<Adress> adresses = addressRepository.findAll();
        model.addAttribute("address", adresses);
        return "person";
    }

    @PostMapping("/person/add")
    public String PersonAdd(@RequestParam String name, @RequestParam String street, Model model){
        Adress adress = addressRepository.findByStreet(street);
        com.example.zaicev.model.Person person = new com.example.zaicev.model.Person(name, adress);
        personRepository.save(person);
        return "person";
    }

}
