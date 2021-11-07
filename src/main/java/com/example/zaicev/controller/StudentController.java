package com.example.zaicev.controller;

import com.example.zaicev.model.GroupPost;
import com.example.zaicev.model.StudentPost;
import com.example.zaicev.model.SubjectPost;
import com.example.zaicev.repo.GroupRepository;
import com.example.zaicev.repo.StudentRepository;
import com.example.zaicev.repo.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository student;
    @Autowired
    private GroupRepository group;
    @Autowired
    private SubjectRepository subject;

    @GetMapping("/student")
    public String studentMain(Model model) {
        Iterable<StudentPost> students = student.findAll();
        Iterable<GroupPost> groups = group.findAll();
        Iterable<SubjectPost> subjects = subject.findAll();
        model.addAttribute("students", students);
        model.addAttribute("groups", groups);
        model.addAttribute("subjects", subjects);
        return "student-main";
    }

    @GetMapping("/student/{id}")
    public String studentMain(@PathVariable(value = "id") long id, Model model) {
        if (!student.existsById(id)) {
            return "redirect:/student";
        }
        Optional<StudentPost> studentPost = student.findById(id);
        ArrayList<StudentPost> res = new ArrayList<>();
        studentPost.ifPresent(res::add);
        model.addAttribute("students", res);

        return "student-details";
    }

    //Студенты
    @GetMapping("/student/{id}/edit")
    public String studentEdit(
            @PathVariable(value = "id") Long id,
                              Model model) {
        if (!student.existsById(id)) {
            return "redirect:/student";
        }
        Optional<StudentPost> post = student.findById(id);
        ArrayList<StudentPost> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("studentPost", res);
        return "student-edit";
    }


    @PostMapping("/student/{id}/edit")
    public String studentUpdate(@Valid StudentPost studentPost,
                                BindingResult bindingResult,
            @PathVariable(value = "id") Long id, @RequestParam String name, @RequestParam String surename,
                                @RequestParam String midlle_name, @RequestParam String phone_number, @RequestParam String adress,
                                @RequestParam String bday, @RequestParam String gruop, Model model) {
        StudentPost post = student.findById(id).orElseThrow();
        post.setName(name);
        post.setSurename(surename);
        post.setMidlle_name(midlle_name);
        post.setPhone_number(phone_number);
        post.setAdress(adress);
        post.setBday(bday);
        post.setGruop(gruop);
        student.save(post);
        return "redirect:/student";
    }

    @PostMapping("/student/{id}/remove")
    public String studentRemove(@PathVariable(value = "id") Long id,  Model model){
        StudentPost post = student.findById(id).orElseThrow();
        student.delete(post);
        return "redirect:/student";
    }



    //Предметы
    @GetMapping("/subject/{id}/edit")
    public String subjectEdit(@PathVariable(value = "id") Long id, Model model) {
        if (!subject.existsById(id)) {
            return "redirect:/student";
        }
        Optional<SubjectPost> post = subject.findById(id);
        ArrayList<SubjectPost> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("subject", res);
        return "subject-edit";
    }

    @PostMapping("/subject/{id}/edit")
    public String subjectUpdate(@PathVariable(value = "id") Long id, @RequestParam String nameSubject, @RequestParam Long subjectLong , Model model) {
        SubjectPost post = subject.findById(id).orElseThrow();
        post.setNameSubject(nameSubject);
        post.setSubjectLong(subjectLong);
        subject.save(post);
        return "redirect:/student";
    }

    @PostMapping("/subject/{id}/remove")
    public String subjectRemove(@PathVariable(value = "id") Long id,  Model model){
        SubjectPost post = subject.findById(id).orElseThrow();
        subject.delete(post);
        return "redirect:/student";
    }


    //Группы
    @GetMapping("/group/{id}/edit")
    public String groupEdit(@PathVariable(value = "id") Long id, Model model) {
        if (!group.existsById(id)) {
            return "redirect:/student";
        }
        Optional<GroupPost> post = group.findById(id);
        ArrayList<GroupPost> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("group", res);
        return "group-edit";
    }

    @PostMapping("/group/{id}/edit")
    public String groupUpdate(@PathVariable(value = "id") Long id, @RequestParam String nameGroup, @RequestParam int count_number , Model model) {
        GroupPost post = group.findById(id).orElseThrow();
        post.setNameGroup(nameGroup);
        post.setCount_number(count_number);
        group.save(post);
        return "redirect:/student";
    }

    @PostMapping("/group/{id}/remove")
    public String groupRemove(@PathVariable(value = "id") Long id,  Model model){
        GroupPost post = group.findById(id).orElseThrow();
        group.delete(post);
        return "redirect:/student";
    }
}
