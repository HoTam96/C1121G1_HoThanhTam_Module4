package com.example.service.impl;


import com.example.model.Bank;
import com.example.repository.IBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService implements IBankService {
    @Autowired
    private IBankRepository iBankRepository;

    @Override
    public List<Bank> findAll() {
        return iBankRepository.findAll();
    }

    @Override
    public void save(Bank bank) {
        iBankRepository.save(bank);
    }

    @Override
    public Bank getBankById(Integer id) {
        return iBankRepository.findById(id).get();
    }

    @Override
    public void update(Bank bank) {
        iBankRepository.save(bank);
    }

    @Override
    public void delete(Integer id) {
        iBankRepository.deleteById(id);
    }

    @Override
    public List<Bank> search(String name) {
        return iBankRepository.findAllByCustomer_NameContaining(name);
    }
}
