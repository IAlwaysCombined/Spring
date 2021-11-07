package com.example.zaicev.controller;

import com.example.zaicev.model.Role;
import com.example.zaicev.model.User;
import com.example.zaicev.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
//@PreAuthorize("hasAnyAuthority('USER')")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("/{id}/edit")
    public String adminEdit(@PathVariable(value = "id") Long id, Model model){
        Optional<User> user = userRepository.findById(id);
        ArrayList<User> res = new ArrayList<>();
        user.ifPresent(res::add);
        model.addAttribute("user", res);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String saveUser(@RequestParam String username, @RequestParam(name = "roles[]", required = false) String[] roles,
                           @RequestParam("userId") User user){
        user.setUsername(username);
        user.getRoles().clear();
        if(roles != null){
            Arrays.stream(roles).forEach(r -> user.getRoles().add(Role.valueOf(r)));
        }
        userRepository.save(user);

        return "redirect:/admin";
    }
}
