package com.example.demo.controller;

import com.example.demo.model.UserDto;
import com.example.demo.model.Users;
import com.example.demo.service.IUserService;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping("")
    public String showFormCreate(Model model) {
        List<Users> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {

        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("/create")

    public String createUser(@Validated @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println("okas");
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Users users = new Users();
        BeanUtils.copyProperties(userDto, users);
        userService.save(users);
        return "redirect:/";
    }

}
