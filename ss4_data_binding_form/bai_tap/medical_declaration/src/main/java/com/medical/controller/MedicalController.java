package com.medical.controller;

import com.medical.model.MedicalDeclaration;
import com.medical.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MedicalController {
    @Autowired
    private IMedicalService imedicalService;


    @GetMapping("/")
    public ModelAndView getinfor() {
        MedicalDeclaration medicalDeclaration = new MedicalDeclaration();
        ModelAndView modelAndView = new ModelAndView("homePage", "medical", medicalDeclaration);
        return modelAndView;

    }
@PostMapping("/update")
    public ModelAndView update(@ModelAttribute("medical") MedicalDeclaration medicalDeclaration) {
        imedicalService.update(medicalDeclaration);
        List<MedicalDeclaration> list = imedicalService.getAllList();
        ModelAndView modelAndView = new ModelAndView("list","list",list);
        return modelAndView;
    }

}
