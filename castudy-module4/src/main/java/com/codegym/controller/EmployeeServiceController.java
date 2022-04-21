package com.codegym.controller;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.service.ICustomerService;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/furama/employee")
public class EmployeeServiceController {
    @Autowired
    private IEmployeeService iEmployeeService;

    //    wep service
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Employee employee = iEmployeeService.findById(id);
        employee.setFlag(false);
        iEmployeeService.update(employee);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> displayById(@PathVariable Integer id) {
        Employee employee = iEmployeeService.findById(id);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
