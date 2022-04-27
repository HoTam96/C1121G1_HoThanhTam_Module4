package com.codegym.service.impl;

import com.codegym.dto.CustomerUsedServiceDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.repository.ICustomerRepository;
import com.codegym.repository.ICustomerTypeRepository;
import com.codegym.repository.ICustomerUserRepositoryDto;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerUsedServiceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Autowired
    private ICustomerUserRepositoryDto iCustomerUserRepositoryDto;


    @Override
    public Page<Customer> findByAllCustomer(Pageable pageable, String name) {
        return iCustomerRepository.findAllByName(pageable, name);
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findByAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }


    @Override
    public List<CustomerType> findByAllCustomerType() {
        return iCustomerTypeRepository.findAll();


    }

    @Override
    public Page<ICustomerUsedServiceDto> findByCustomerUsedService(Pageable pageable, String name) {
        return iCustomerUserRepositoryDto.findAllByCustomerNameContaining(ICustomerUsedServiceDto.class,pageable, name);
    }

}