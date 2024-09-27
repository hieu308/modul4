package com.example.demo.controller;

import com.example.demo.exception.CodeException;
import com.example.demo.exception.QuantityException;
import com.example.demo.model.Book;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class BookController {
    @Autowired
    IBookService bookService;

    @GetMapping("")
    public String showList(Model model) {
        List<Book> list = bookService.findAll();
        model.addAttribute("listBook", list);
        return "book";

    }

    @PostMapping("/borrow")
    public String borrow(@RequestParam("id") Long id) throws QuantityException {
        System.out.println("id : " + id);
        Book book = bookService.findById(id);
        bookService.checkQuantity(book);
        return "redirect:/";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("code") String code)throws CodeException {
        System.out.println(code);
        bookService.checkCode(code);
      return "redirect:/";

    }
    @ExceptionHandler(QuantityException.class)
    public String handleQuantityException(QuantityException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());  // Gửi thông điệp lỗi ra view
        return "home-error";
    }
    @ExceptionHandler(CodeException.class)
    public String handleCodeException(CodeException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "home-error";
    }

}
