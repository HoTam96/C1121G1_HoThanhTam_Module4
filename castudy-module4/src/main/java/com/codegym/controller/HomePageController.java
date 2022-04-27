package com.codegym.controller;

import com.codegym.model.service.ServiceType;
import com.codegym.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomePageController {
    @Autowired
    private IFacilityService iFacilityService;
    @GetMapping("/home")
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView("homePage");
        List<ServiceType> serviceTypeList = iFacilityService.getAll();
        modelAndView.addObject("serviceTypeList", serviceTypeList);
        return modelAndView;
    }
}
