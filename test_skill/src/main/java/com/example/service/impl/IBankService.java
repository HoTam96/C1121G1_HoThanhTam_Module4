package com.example.service.impl;

import com.example.model.Bank;

import java.util.List;

public interface IBankService {

    List<Bank>findAll();

    void save(Bank bank);
    Bank getBankById(Integer id);
    void update(Bank bank);
    void delete(Integer id);
    List<Bank>search(String name);
    List<Bank>findByNameCustomer(String name);
}
