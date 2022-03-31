package com.medical.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MedicalController {

    @GetMapping("/")
    public ModelAndView getinfor() {
        

        return "homePage";
    }



}
