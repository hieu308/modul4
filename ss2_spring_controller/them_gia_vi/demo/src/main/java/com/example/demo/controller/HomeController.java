package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "order";
    }

    @PostMapping("/order")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "order";
    }
}
