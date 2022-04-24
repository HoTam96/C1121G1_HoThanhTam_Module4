package com.codegym.repository;

import com.codegym.dto.CustomerUsedServiceDto;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerUsedServiceRepository extends JpaRepository<CustomerUsedServiceDto, Integer> {
    Page<CustomerUsedServiceDto> findAllByCustomerNameContaining (Pageable pageable, String keyWord);

}
