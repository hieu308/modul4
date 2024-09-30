package com.example.demo.controller;

import com.example.demo.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoppingController {
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView shoppingCart(
        @SessionAttribute("cart") Cart cart){
            ModelAndView mav = new ModelAndView("/cart");
            mav.addObject("cart", cart);
            return mav;
        }

}
