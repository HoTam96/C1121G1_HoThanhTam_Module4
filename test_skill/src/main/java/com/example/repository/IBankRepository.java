package com.example.repository;

import com.example.model.Bank;
import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBankRepository extends JpaRepository<Bank, Integer> {
    List<Bank> findAllByCustomer_NameContaining(String name);
}
