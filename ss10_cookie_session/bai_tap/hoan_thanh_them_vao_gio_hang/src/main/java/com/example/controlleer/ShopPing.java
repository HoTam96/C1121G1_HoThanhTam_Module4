package com.example.controlleer;

import com.example.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopPing {
    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/carts")
    public ModelAndView shopPingCart(@SessionAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("payment");
        modelAndView.addObject("cart", cart);
        return modelAndView;


    }

}
