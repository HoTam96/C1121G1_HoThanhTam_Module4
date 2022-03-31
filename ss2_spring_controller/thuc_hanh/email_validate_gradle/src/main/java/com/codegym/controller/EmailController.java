package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$
//^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$
@Controller
public class EmailController {
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private Pattern pattern;
    private Matcher matcher;

    public EmailController() {
        pattern = Pattern.compile(REGEX_EMAIL);

    }

    @GetMapping("/")
    String getIndex() {
        return "index";
    }

    @PostMapping("/validate")
    String validateEmail(@RequestParam("email") String email, Model model) {
        boolean validate =this.validate(email);
        if (!validate) {
            model.addAttribute("message", "Email is invalid");
            return "index";
        }
        model.addAttribute("email", email);
        return "suceess";

    }

    private boolean validate(String regex) {
        return regex.matches(REGEX_EMAIL);
//        pattern = Pattern.compile(REGEX_EMAIL);
//        matcher = pattern.matcher(regex);
//        return matcher.matches();
    }


}


