package com.codegym.dto;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.util.Set;
public class CustomerDto {
    @NotBlank
    private String name;
    @NotBlank
    private String dateOfBirth;
    @NotBlank
    private String idCard;
    @NotBlank
    private String phone;
    private String email;
    private String address;
    private Boolean flag;
    private Integer id;
    private String customerCode;
    private String gender;
    private CustomerType customerType;
    private Set<Contract> contracts;

    public CustomerDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }


}
