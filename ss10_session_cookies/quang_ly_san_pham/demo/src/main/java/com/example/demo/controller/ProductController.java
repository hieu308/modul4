package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Products;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@SessionAttributes("cart")
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public ModelAndView shop() {
        ModelAndView mav = new ModelAndView("shop");
        mav.addObject("products", productService.findAllProducts());
        return mav;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Optional<Products> productsOptional = productService.findProductsById(id);
        if (!productsOptional.isPresent()) {
            return "/error_404";
        }
        if (action.equals("show")) {
            cart.addProduct(productsOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productsOptional.get());
        return "redirect:/";
    }

    @GetMapping("/reduce/{id}")
    public String reduce(@PathVariable("id") Long id,
                         @ModelAttribute Cart cart) {
        Optional<Products> productsOptional = productService.findProductsById(id);
        cart.reduceQuantity(productsOptional.get());
        return "redirect:/shopping-cart";

    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(@PathVariable("id") Long id,
                                 @ModelAttribute Cart cart) {
        System.out.println(id);
        Optional<Products> productsOptional = productService.findProductsById(id);
        if (productsOptional.isPresent()) {

            cart.removeProduct(productsOptional.get());
            System.out.println("xoá");

        }
        return "redirect:/shopping-cart";
    }

    @GetMapping("/detail/{id}")
    public String getProductDetail(@PathVariable Long id, Model model) {
        Optional<Products> productsOptional = productService.findProductsById(id);
        if (productsOptional.isPresent()) {
            model.addAttribute("product", productsOptional.get());
            return "product";
        }

        return "redirect:/shopping-cart";
    }

    @GetMapping("/clear-cart")
    public String clearCart(@ModelAttribute Cart cart, RedirectAttributes redirectAttributes) {
        cart.clearCart();
        redirectAttributes.addFlashAttribute("message","Thanh toan  thành công");
        return "redirect:/shopping-cart";
    }

}
