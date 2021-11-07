package com.example.zaicev.controller;

import com.example.zaicev.repo.Student;
import com.example.zaicev.repo.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Many {
    @Autowired
    private Student studentRepository;
    @Autowired
    private University universityRepository;

    @GetMapping("/uni")
    private String Main (Model model){
        Iterable<com.example.zaicev.model.Student> students = studentRepository.findAll();
        model.addAttribute("students", students);
        Iterable<com.example.zaicev.model.University> universities = universityRepository.findAll();
        model.addAttribute("universities", universities);

        return "uni";
    }

    @PostMapping("/uni/add")
    public String AddUser(@RequestParam String student, @RequestParam String university, Model model){
        com.example.zaicev.model.Student student2 = studentRepository.findByName(student);
        com.example.zaicev.model.University university2 = universityRepository.findByName(university);
        student2.getUniversities().add(university2);
        university2.getStudents().add(student2);
        studentRepository.save(student2);
        return "uni";
    }
}
