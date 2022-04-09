package com.example.repository;

import com.example.model.Bank;
import com.example.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBankRepository extends JpaRepository<Bank, Integer> {
    @Query("select b from Bank b where b.customer.name like concat('%',:name,'%')")
    List<Bank> findAllByCustomer_NameContaining(@Param("name") String name);

    Bank findByCodeBankAndCustomer_Name(String code, String name);


}
