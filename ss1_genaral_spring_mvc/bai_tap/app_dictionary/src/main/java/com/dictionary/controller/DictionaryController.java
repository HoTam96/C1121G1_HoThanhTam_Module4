package com.dictionary.controller;

import com.dictionary.repository.IDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionary iDictionary;

    @GetMapping("/")
    public String delivery() {

        return "dictinary";
    }

    @PostMapping("/dictionnary")
    public String getDictionary(@RequestParam String name, Model model) {
        String result = iDictionary.result(name);
        model.addAttribute("dictionary", result);
        return "dictinary";
    }

}
