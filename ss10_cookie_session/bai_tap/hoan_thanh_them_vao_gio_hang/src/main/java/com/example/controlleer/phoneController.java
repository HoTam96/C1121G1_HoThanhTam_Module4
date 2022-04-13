package com.example.controlleer;


import com.example.model.Cart;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/product")
@Controller
@SessionAttributes("cart")
public class phoneController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("")
    public ModelAndView showProduct() {
        List<Product> productList = iProductService.findAll();
        ModelAndView modelAndView = new ModelAndView("list", "productList", productList);
        return modelAndView;

    }

    @GetMapping("/add/{id}")
    public ModelAndView addCart(@PathVariable Integer id, @RequestParam String action, @ModelAttribute Cart cart) {
        Product product = iProductService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        if (action.equals("show")) {
            cart.addNewProduct(product);
            modelAndView.setViewName("redirect:/carts");
            return modelAndView;
        }
        cart.addNewProduct(product);

        modelAndView.setViewName("redirect:/product");
        return modelAndView;

    }


}
