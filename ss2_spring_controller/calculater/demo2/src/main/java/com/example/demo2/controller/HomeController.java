package com.example.demo2.controller;

import com.example.demo2.service.ICalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
    @Autowired
    ICalculateService calculateService;

    @GetMapping("/")
    public String home() {
        return "/index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("a") double a, @RequestParam("b") double b, @RequestParam("operation") String operation, RedirectAttributes redirectAttributes) {
        if (b != 0) {
            double result = calculateService.calculate(a, b, operation);

            redirectAttributes.addFlashAttribute("result", result);
        } else {
            redirectAttributes.addFlashAttribute("result", "số chia phải khác 0");
        }

        return "redirect:/";

    }

}
