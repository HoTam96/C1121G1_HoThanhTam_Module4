package com.email.controller;

import com.email.model.Email;
import com.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private IEmailService iEmailService;

    @GetMapping("/")
    public ModelAndView showEmail() {
        Email email = new Email();
        ModelAndView modelAndView = new ModelAndView("home", "email", email);
        return modelAndView;
    }

    @PostMapping("/email")
    public ModelAndView configsEmail(@ModelAttribute("email") Email email) {
        ModelAndView modelAndView = new ModelAndView("show", "email", email);
        return modelAndView;
    }
    @PostMapping ("/list")
    public ModelAndView getList(@ModelAttribute("email") Email email){
        iEmailService.update(email);
        List<Email>emailList = iEmailService.getListAll();
       ModelAndView modelAndView = new ModelAndView("list","list",emailList);
       return modelAndView;

    }


}
