package com.codegym.repository;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query("select e from Employee e where e.flag=true and e.name  like concat('%', :name ,'%') ")
    Page<Employee> findAllByName(Pageable pageable, @Param("name") String keyWord);
}
