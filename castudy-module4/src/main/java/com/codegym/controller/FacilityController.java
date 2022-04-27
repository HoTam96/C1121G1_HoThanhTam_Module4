package com.codegym.controller;


import com.codegym.dto.ServiceDto;
import com.codegym.model.service.RentType;
import com.codegym.model.service.Service;
import com.codegym.model.service.ServiceType;
import com.codegym.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;

    @ModelAttribute
    public List<ServiceType> serviceTypeList() {
        List<ServiceType> serviceTypeList = iFacilityService.getAll();
        return serviceTypeList;
    }

    @ModelAttribute
    public List<RentType> rentTypeList() {
        List<RentType> rentTypeList = iFacilityService.getAllRenType();
        return rentTypeList;
    }

    @ModelAttribute
    public List<String> free() {
        List<String> free = new ArrayList<>();
        free.add("khải 1h đầu 60k");
        free.add("khải 2h 150k");
        free.add("khải đi tour thương lượng");
        return free;
    }


    @GetMapping("/createService/{id}")
    public ModelAndView CreateNewService(@PathVariable("id") Integer serviceTypeId) {
        ServiceDto serviceDto = new ServiceDto();
        ModelAndView modelAndView = new ModelAndView("facility/create",
                "serviceTypeList", serviceTypeList());
        modelAndView.addObject("serviceDto", serviceDto);
        modelAndView.addObject("rentTypeList", rentTypeList());
        modelAndView.addObject("serviceTypeId", serviceTypeId);
        modelAndView.addObject("free", free());
        return modelAndView;

    }

    @PostMapping("/save")
    public ModelAndView save(@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult) {
        Service service = new Service();
        ServiceDto serviceErorrDto = new ServiceDto();
        serviceErorrDto.setiFacilityService(iFacilityService);
        serviceErorrDto.validate(serviceDto,bindingResult);
        Integer id = serviceDto.getServiceType().getId();
        ModelAndView modelAndView = new ModelAndView();
        BeanPropertyBindingResult beanPropertyBindingResult = (BeanPropertyBindingResult) bindingResult;


        if (id ==2){
            List<FieldError>errorList = beanPropertyBindingResult.getFieldErrors().stream()
                    .filter(fer -> !fer.getField().equals("poolArea")).collect(Collectors.toList());
            beanPropertyBindingResult = new BeanPropertyBindingResult(serviceDto,"serviceDto");

            for (FieldError fieldError : errorList) {
                beanPropertyBindingResult.addError(fieldError);
            }

        }
        if (id==3){
            List<FieldError>errorList = beanPropertyBindingResult.getFieldErrors().stream()
                    .filter(fer -> !fer.getField().equals("numberFloor")).collect(Collectors.toList());
            beanPropertyBindingResult = new BeanPropertyBindingResult(serviceDto,"serviceDto");

            for (FieldError fieldError : errorList) {
                beanPropertyBindingResult.addError(fieldError);
            }

        }

        if (beanPropertyBindingResult.hasFieldErrors()) {
            modelAndView.addObject("serviceDto", serviceDto);
            modelAndView.addObject("rentTypeList", rentTypeList());
            modelAndView.addObject("serviceTypeId", id);
            modelAndView.addObject("free", free());
            modelAndView.setViewName("facility/create");
            return modelAndView;
        }
        BeanUtils.copyProperties(serviceDto, service);
        service.setServiceType(serviceDto.getServiceType());
        service.setRentType(serviceDto.getRentType());
        iFacilityService.save(service);
        modelAndView.setViewName("redirect:/facility/home");
        return modelAndView;

    }



}
