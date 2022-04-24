package com.codegym.dto;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;

import com.codegym.model.employee.Employee;
import com.codegym.model.service.Service;
import com.codegym.service.IContractService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;


public class ContractDto implements Validator {
    private Integer id;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^$|((HD-)[0-9]{4})")
    private String contractCode;
    @NotBlank
    private String startDate;
    @NotBlank
    private String endDate;
    @NotNull(message = "khống được để trống")
    @Pattern(regexp = "^$|([1-9](\\.?[0-9]+)?)|0\\.[1-9]+")
    private Double deposite;
    @NotNull(message = "khống được để trống")
    @Pattern(regexp = "^$|([1-9](\\.?[0-9]+)?)|0\\.[1-9]+")
    private Double totalMoney;

    private Employee employee;

    private Customer customer;

    private Service service;

    private IContractService iContractService;

    public ContractDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getDeposite() {
        return deposite;
    }

    public void setDeposite(Double deposite) {
        this.deposite = deposite;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public IContractService getiContractService() {
        return iContractService;
    }

    public void setiContractService(IContractService iContractService) {
        this.iContractService = iContractService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }


    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        List<Contract>contractList =iContractService.findByAllContract();
        for (Contract element:contractList) {
            if (element.getContractCode().equals(contractDto.contractCode)){
                errors.rejectValue("contractCode", "contract.code","mã hợp đồng đã tồn tại");
            }
        }
    }
}
