package com.codegym.service;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
     Page<Customer>findAllCustomer(Pageable pageable , String keyWord);
     void save(Customer customer);

}
