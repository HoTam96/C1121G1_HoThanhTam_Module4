package com.codegym.dto;

import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.service.ICustomerService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

public class CustomerDto implements Validator {
    @NotBlank(message = " tên không được để trống")
    @Pattern(regexp = "^$|(^[\\p{Lu}\\p{Ll}\\s]+$)")
    private String name;
    @NotBlank(message = " ngày sinh không được để trống")
    private String dateOfBirth;
    @NotBlank(message = "CMND không được để trống")
    @Pattern(regexp = "^$|(^(([0-9]{9})|([0-9]{12}))$)", message = "CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX ")
    private String idCard;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "(^$|(090|091|(\\+(84)90)|(\\+(84)91))([0-9]{7}))", message = "số điện thoại sai định dạng")
    private String phone;
    @NotBlank(message = "email không được để trống")
    @Pattern(regexp = "^$|(^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$)", message = "email phải đúng định dạng")
    private String email;
    private String address;
    private Boolean flag;
    private Integer id;
    @NotBlank(message = "mã khách hàng không được để trống")
    @Pattern(regexp = "^$|((KH-)[0-9]{4})", message = "định dạng đúng là KH-XXXX (X là số từ 0-9)")
    private String customerCode;
    private String gender;
    private CustomerType customerType;
    private ICustomerService iCustomerService;
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

    public ICustomerService getiCustomerService() {
        return iCustomerService;
    }

    public void setiCustomerService(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        List<Customer> customers = this.iCustomerService.findByAll();
        for (Customer element : customers) {
            if (element.getCustomerCode().equals(customerDto.customerCode)) {
                errors.rejectValue("customerCode", "cusrtomer.code", "mã khách hàng đã tồn tại");
            }
        }

    }

}