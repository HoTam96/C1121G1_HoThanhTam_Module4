package com.codegym.repository;

import com.codegym.dto.CustomerUsedServiceDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerUsedServiceRepository extends JpaRepository<CustomerUsedServiceDto, Integer> {
    @Query(value = "select concat(ifnull(contract_id,0),ifnull(service_id,0),ifnull(customer.id,0),ifnull(attach_service.id,0)) as id," +
            " contract.id as contract_id , customer.name , customer.customer_code , contract.contract_code,service.name as service_name ," +
            " service.id as service_id, service_code, attach_service_name,contract_detail.quantity,attach_service.unit," +
            " sum(ifnull(service_cost,0) + ifnull(contract_detail.quantity,0)*ifnull(attach_service_cost,0)) as total_payment " +
            " from customer" +
            " join contract on contract.customer_id = customer.id " +
            " join service on contract.service_id = service.id " +
            " left join contract_detail on contract_detail.contract_id = contract.id " +
            " left join attach_service on attach_service.id = contract_detail.attach_service_id " +
            " where customer.flag = true and customer.name like concat ('%', :name , '%' )" +
            " group by id",
            countQuery = "select count(*) " +
                    " from customer" +
                    " join contract on contract.customer_id = customer.id " +
                    " join service on contract.service_id = service.id " +
                    " left join contract_detail on contract_detail.contract_id = contract.id " +
                    " left join attach_service on attach_service.id = contract_detail.attach_service_id " +
                    " where customer.flag = true and customer.name like concat ('%', :name , '%' )" +
                    " group by id"
            ,nativeQuery = true)
    Page<CustomerUsedServiceDto> findAllByCustomerNameContaining (Pageable pageable , @Param("name") String keyWord);

}
//@Query("select c from Customer c where c.flag=true and c.name  like concat('%', :name ,'%') ")

