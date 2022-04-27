package com.codegym.repository;

import com.codegym.dto.CustomerUsedServiceDto;
import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerUserRepositoryDto extends JpaRepository<Customer , Integer> {

@Query(value = "    select " +
        "        contract.id as id  , customer.name , customer.customer_code as customerCode , contract.contract_code as contractCode, service.name as serviceName ," +
        "        service.id as serviceId, service_code as ServiceCode, attach_service_name as attachServiceName,ifnull(contract_detail.quantity,0) as quantity ,nullif (attach_service.unit,0)," +
        "        (ifnull (service_cost,0) + ifnull (contract_detail.quantity,0)*ifnull (attach_service_cost,0)) as totalPayment" +
        "        from customer" +
        "        join contract on contract.customer_id = customer.id" +
        "        join service on contract.service_id = service.id" +
        "        left join contract_detail on contract_detail.contract_id = contract.id" +
        "        left join attach_service on attach_service.id = contract_detail.attach_service_id" +
        "        where customer.flag = true and customer.name like concat ('%', :name , '%' )",
        countQuery = "select count(*) " +
        " from customer" +
        " join contract on contract.customer_id = customer.id " +
        " join service on contract.service_id = service.id " +
        " left join contract_detail on contract_detail.contract_id = contract.id " +
        " left join attach_service on attach_service.id = contract_detail.attach_service_id " +
        " where customer.flag = true and customer.name like concat ('%', :name , '%' )"
        , nativeQuery = true)
   <T>Page<T> findAllByCustomerNameContaining ( Class<T>tClass ,   Pageable pageable , @Param("name") String keyWord);

}
