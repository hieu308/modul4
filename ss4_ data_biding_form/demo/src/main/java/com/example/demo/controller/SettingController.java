package com.example.demo.controller;

import com.example.demo.model.SettingEmail;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SettingController {
    @GetMapping("/")
    public String showSetting(Model model) {
        model.addAttribute("setting", new SettingEmail("Vietnamese",5,"code_gym"));
        return "showSetting";
    }
    @GetMapping("/showFormEdit")
    public String showFormEdit(Model model ) {
        model.addAttribute("setting", new SettingEmail());
        return "showFormEdit";
    }
    @PostMapping("/settingEmail")
    public String saveSettingEmail(@ModelAttribute("setting") SettingEmail setting, Model model) {
        model.addAttribute("setting", setting);
        return "showSetting";
    }
}
