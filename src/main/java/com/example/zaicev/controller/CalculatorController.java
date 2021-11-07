package com.example.zaicev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class CalculatorController {
    @GetMapping("/calculator")
    public String home(@RequestParam(value = "a")  int a,
           @RequestParam(value = "b")  int b, @RequestParam(value = "action") String action, Model model) {
        double result;
        switch (action){
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double)b;
                break;
            case "substraction":
                result = a - b;
                break;
            case "addiction":
                result = a + b;
                break;
            default:
                result = 0;
                break;
        }
        model.addAttribute("result", result);

        return "Calc";
    }
}