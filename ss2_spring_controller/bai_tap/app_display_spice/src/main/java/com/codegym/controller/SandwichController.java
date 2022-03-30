package com.codegym.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

@Controller
public class SandwichController {

    @Autowired


    @GetMapping("/")
    public String getInfor() {
        return "index";
    }

    @PostMapping("/sandWich")
    public String getCheckSandWich(@RequestParam("condiment") String[] str, Model model) {
        if (str==null){
            model.addAttribute("message","không được để trống");
            return "index";
        }
        model.addAttribute("condiment", str);
        return "list";
    }

}
