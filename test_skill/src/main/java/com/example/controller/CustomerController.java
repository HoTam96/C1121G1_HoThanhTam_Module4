package com.example.controller;


import com.example.dto.BankDto;
import com.example.dto.CustomerDto;
import com.example.model.Bank;
import com.example.model.Customer;
import com.example.service.ICustomerService;
import com.example.service.impl.IBankService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/bank")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    IBankService iBankService;
    @GetMapping("")
    public ModelAndView getHome(){
        List<Bank> bankList = iBankService.findAll();
        ModelAndView modelAndView = new ModelAndView("list","bankList",bankList);
        modelAndView.addObject("bankList",bankList);
        return modelAndView;
    }

    @GetMapping("/createBank")
    public ModelAndView getInforBank() {
        BankDto bankDto = new BankDto();
        List<Customer> customerList = iCustomerService.findAll();
        ModelAndView modelAndView = new ModelAndView("create", "bankDto", bankDto);
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView CreateBank(@Valid @ModelAttribute BankDto bankDto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        bankDto.validate(bankDto,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            modelAndView.setViewName("create");
            List<Customer> customerList = iCustomerService.findAll();
            modelAndView.addObject("customerList", customerList);
            return modelAndView;
        }
        Bank bank = new Bank();
        BeanUtils.copyProperties(bankDto, bank);
        Customer customer = new Customer();
        customer.setName(bankDto.getCustomer().getName());
        bank.setCustomer(customer);




        
        iBankService.save(bank);
        modelAndView.setViewName("redirect:/bank");
        return modelAndView;
    }

    @GetMapping("/showEdit/{id}")
    public ModelAndView showEdit(@PathVariable("id") Integer id) {
        Bank bank = iBankService.getBankById(id);
        BankDto bankDto = new BankDto();
        BeanUtils.copyProperties(bank, bankDto);
        List<Customer> customerList = iCustomerService.findAll();
        ModelAndView modelAndView = new ModelAndView("edit", "bankDto", bank);
        modelAndView.addObject("customerList", customerList);
        return modelAndView;


    }

    @PostMapping("/saveEit")
    public ModelAndView saveEit(@Valid @ModelAttribute BankDto bankDto, BindingResult bindingResult ){
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasFieldErrors()) {
            modelAndView.setViewName("edit");
            List<Customer> customerList = iCustomerService.findAll();
            modelAndView.addObject("customerList", customerList);
            return modelAndView;
        }
        Bank bank = new Bank();
        BeanUtils.copyProperties(bankDto, bank);
        Customer customer = new Customer();
        customer.setName(bankDto.getCustomer().getName());
        bank.setCustomer(customer);
        iBankService.update(bank);
        List<Bank> bankList = iBankService.findAll();
        modelAndView.setViewName("list");
        modelAndView.addObject("bankList", bankList);
        return modelAndView;

    }
    @GetMapping("/delete/{id}")
    public  String delete(@PathVariable("id") Integer id){
        iBankService.delete(id);
        return "redirect:/bank";

    }

    @PostMapping("/search")
    public ModelAndView search(@RequestParam("namB") String name){
        List<Bank> bankList = iBankService.findByNameCustomer(name);
        ModelAndView modelAndView = new ModelAndView("list","bankList",bankList);
        modelAndView.addObject("bankList",bankList);
        modelAndView.addObject("name",name);
        return modelAndView;
    }



}
