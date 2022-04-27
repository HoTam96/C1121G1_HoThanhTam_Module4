package com.codegym.service;


import com.codegym.dto.CustomerUsedServiceDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ICustomerService {
    Page<Customer> findByAllCustomer(Pageable pageable, String name);

    Customer findById(Integer id);
    List<Customer>findByAll();

    void save(Customer customer);
    void update(Customer customer);

    List<CustomerType> findByAllCustomerType();

    Page<ICustomerUsedServiceDto> findByCustomerUsedService(Pageable pageable, String name);
}
