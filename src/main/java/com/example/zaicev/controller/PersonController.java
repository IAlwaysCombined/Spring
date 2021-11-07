package com.example.zaicev.controller;

import com.example.zaicev.model.PersonModel;
import com.example.zaicev.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller

public class PersonController {
    @Autowired
    private PersonRepository personDAO;

    @GetMapping("/person")
    public String create(Model model){
        model.addAttribute("person", new PersonModel());
        return "edit";
    }

    @PostMapping("/person")
    public String update(@Valid @ModelAttribute("person")  PersonModel person, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "edit";
        }
        personDAO.save(person);
        model.addAttribute("check", "Запись добавлена");
        return "edit";
    }
}
