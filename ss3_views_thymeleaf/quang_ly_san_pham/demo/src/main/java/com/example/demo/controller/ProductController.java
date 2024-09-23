package com.example.demo.controller;

import com.example.demo.model.Products;
import com.example.demo.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    IProductsService productsService;
    @GetMapping("/")
    public String showHome(Model model) {
        List<Products> productsList = productsService.findAll();
        model.addAttribute("productsList", productsList);
        return "home";
    }
    @GetMapping("/create")
    public String create(Model model) {
        System.out.println( "alo");
        model.addAttribute("product", new Products());
        return "create";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("product") Products product, RedirectAttributes redirectAttributes) {
        productsService.save(product);
        redirectAttributes.addFlashAttribute("success", true); // Thêm thuộc tính success
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("productId") int productId,RedirectAttributes redirectAttributes) {
        System.out.println("Deleting product with ID: " + productId);
        productsService.delete(productId);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/";

    }
    @GetMapping("/view")
    public String view(@RequestParam("id") int productId, Model model) {
        Products product = productsService.findById(productId);
        model.addAttribute("product", product);
        return "view";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam("id") int productId, Model model) {
        Products product = productsService.findById(productId);
        model.addAttribute("product", product);
        return "edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute("product") Products product,RedirectAttributes redirectAttributes) {
        productsService.save(product);
        redirectAttributes.addFlashAttribute("success", true);

        return "redirect:/";
    }


}
