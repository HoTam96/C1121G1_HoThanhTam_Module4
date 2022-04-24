package com.codegym.repository;

import com.codegym.dto.CustomerUsedServiceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerUsedServiceRepository extends JpaRepository<CustomerUsedServiceDto, Integer> {
    Page<CustomerUsedServiceDto> findAllByCustomerNameContaining (Pageable pageable, String keyWord);

}
