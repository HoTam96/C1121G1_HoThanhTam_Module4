package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/furama/customer")
public class CustomerServiceController {
    @Autowired
    private ICustomerService iCustomerService;

    //    wep service
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Customer customer = iCustomerService.findById(id);
        customer.setFlag(false);
        iCustomerService.update(customer);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> displayById(@PathVariable Integer id) {
        Customer customer = iCustomerService.findById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
