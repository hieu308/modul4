package com.example.demo1.controller;

import com.example.demo1.service.Calculate;
import com.example.demo1.service.ICalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    ICalculate calculate ;

    @PostMapping ("/result")
    public String currencyConversion(@RequestParam("usd") double amount, Model model) {
        double vnd = calculate.calculate(amount);
        model.addAttribute("result", vnd);
        return "/home";
    }
    @GetMapping("/")
    public String home() {
        return "/home";
    }

}
