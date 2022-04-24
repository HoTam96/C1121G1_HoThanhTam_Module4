package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.CustomerUsedServiceDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/furama")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;


    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 2) Pageable pageable,
                                 @RequestParam Optional<String> keyWord) {
        String keyWordValue = keyWord.orElse("");

        Page<Customer> customerPage = iCustomerService.findByAllCustomer(pageable, keyWordValue);
        ModelAndView modelAndView = new ModelAndView("customer/ListCustomer", "list", customerPage);
        modelAndView.addObject("keyWord", keyWordValue);
        return modelAndView;

    }

    @ModelAttribute
    public List<String> listGender() {
        List<String> gender = new ArrayList<>();
        gender.add("nam");
        gender.add("nữ");
        gender.add("bê đê");
        return gender;

    }

    @GetMapping("/createCustomer")
    public ModelAndView showCreateNew() {
        CustomerDto customerDto = new CustomerDto();

        ModelAndView modelAndView = new ModelAndView("customer/create", "customerDto", customerDto);
        List<CustomerType> customerTypeList = iCustomerService.findByAllCustomerType();
        modelAndView.addObject("customerTypeList", customerTypeList);
        modelAndView.addObject("gender", listGender());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        CustomerDto customerDtoError = new CustomerDto();
        customerDtoError.setiCustomerService(iCustomerService);
        customerDtoError.validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            modelAndView.setViewName("customer/create");
            List<CustomerType> customerTypeList = iCustomerService.findByAllCustomerType();
            modelAndView.addObject("customerTypeList", customerTypeList);
            modelAndView.addObject("gender", listGender());
            return modelAndView;
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.setCustomerType(customerDto.getCustomerType());
        customer.setFlag(true);

        iCustomerService.save(customer);
        modelAndView.setViewName("redirect:/furama/list");
        return modelAndView;
    }

    @GetMapping("/showEdit/{id}")
    public ModelAndView showEdit(@PathVariable("id") Integer id) {
        Customer customer = iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        ModelAndView modelAndView = new ModelAndView("customer/edit", "customerDto", customerDto);
        List<CustomerType> customerTypeList = iCustomerService.findByAllCustomerType();
        modelAndView.addObject("customerTypeList", customerTypeList);
        modelAndView.addObject("gender", listGender());
        return modelAndView;
    }

    @PostMapping("/saveEdit")
    public ModelAndView saveEdit(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        CustomerDto customerDtoError = new CustomerDto();
        customerDtoError.setiCustomerService(iCustomerService);
        customerDtoError.validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            modelAndView.setViewName("customer/edit");
            List<CustomerType> customerTypeList = iCustomerService.findByAllCustomerType();
            modelAndView.addObject("customerTypeList", customerTypeList);
            modelAndView.addObject("gender", listGender());
            return modelAndView;
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        customer.setCustomerType(customerDto.getCustomerType());
        iCustomerService.update(customer);
        modelAndView.setViewName("redirect:/furama/list");
        return modelAndView;
    }

    @GetMapping("/customerUsed")
    public ModelAndView getCustomerUsedService(@PageableDefault(value = 3) Pageable pageable,
                                               @RequestParam Optional<String> keyWord) {

        String keyWordValue = keyWord.orElse("");
//x        Page<Customer>customerUsedPage = iCustomerService.findByCustomerUsedService(pageable,keyWordValue);
        Page<CustomerUsedServiceDto> customerUsedPage = iCustomerService.findByCustomerUsedService(pageable, keyWordValue);
        ModelAndView modelAndView = new ModelAndView("customerUsedService/list", "customerUsedPage", customerUsedPage);
        return modelAndView;

    }


}
