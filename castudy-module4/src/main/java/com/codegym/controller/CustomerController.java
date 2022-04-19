package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/furama")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("")
    ResponseEntity<Page<Customer>> getAllCustomer(@PageableDefault(value = 2) Pageable pageable,
                                                  @RequestParam Optional<String> keySearch) {

        String keyWordValue = keySearch.orElse("");
        Page<Customer> customerPage = iCustomerService.findAllCustomer(pageable, keyWordValue);
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Void> InsertCustomer(@RequestBody Customer customer) {
        iCustomerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);

    }


}
