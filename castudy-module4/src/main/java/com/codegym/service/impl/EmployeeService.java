package com.codegym.service.impl;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;
import com.codegym.repository.IEmployeeRepository;
import com.codegym.service.IDivisionRepository;
import com.codegym.service.IEducation;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Autowired
    private IPositionRepository iPositionRepository;

    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Autowired
    private IEducation iEducation;

    @Override
    public Page<Employee> findByAllCustomer(Pageable pageable, String name) {
        return iEmployeeRepository.findAllByName(pageable, name);
    }

    @Override
    public Employee findById(Integer id) {
        return iEmployeeRepository.findById(id).get();
    }

    @Override
    public void save(Employee customer) {
        iEmployeeRepository.save(customer);
    }

    @Override
    public void update(Employee employee) {
        iEmployeeRepository.save(employee);
    }

    @Override
    public List<Position> findByAllPosition() {
        return iPositionRepository.findAll();
    }

    @Override
    public List<Division> findByAllDivision() {
        return iDivisionRepository.findAll();
    }

    @Override
    public List<EducationDegree> findByAllEducation() {
        return iEducation.findAll();
    }
}



