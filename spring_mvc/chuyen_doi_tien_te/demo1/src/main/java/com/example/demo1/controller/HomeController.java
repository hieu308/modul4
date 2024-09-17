package com.example.demo1.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @PostMapping ("/result")
    public String currencyConversion(@RequestParam("usd") double amount, Model model) {
        double vnd = amount *23000;
        model.addAttribute("result", vnd);
        return "/home";
    }
    @GetMapping("/")
    public String Home() {
        return "/home";
    }

}
