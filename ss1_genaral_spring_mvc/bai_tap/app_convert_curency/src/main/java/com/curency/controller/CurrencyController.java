package com.curency.controller;

import com.curency.service.ICurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @Autowired
    private ICurrency currency;

@GetMapping("/")
public String geturl(){
    return "Convertcurrency";
}

    @PostMapping ("/Currency")
    public String getCurrency(@RequestParam int a , Model model) {
       Double result =  currency.convert(a);
       model.addAttribute("result", result);

        return "Convertcurrency";
    }


}
