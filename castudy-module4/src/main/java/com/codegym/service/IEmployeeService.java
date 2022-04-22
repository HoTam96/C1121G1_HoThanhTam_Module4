package com.codegym.service;

import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findByAllCustomer(Pageable pageable, String name);

    Employee findById(Integer id);
    List<Employee>findByAll();

    void save(Employee employee);
    void update(Employee employee);

    List<Position> findByAllPosition();
    List<Division> findByAllDivision();
    List<EducationDegree> findByAllEducation();
}
