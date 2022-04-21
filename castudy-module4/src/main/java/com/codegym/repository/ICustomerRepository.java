package com.codegym.repository;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query("select c from Customer c where c.flag=true and c.name  like concat('%', :name ,'%') ")
    Page<Customer>findAllByName(Pageable pageable,@Param("name") String keyWord);
}
