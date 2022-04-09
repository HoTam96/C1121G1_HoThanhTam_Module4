package com.example.dto;

import com.example.model.Bank;
import com.example.model.Customer;
import com.example.repository.IBankRepository;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

public class BankDto implements Validator {
    @Autowired
    private IBankRepository iBankRepository ;

    private Integer id;
    @Pattern(regexp = "(MB-)[0-9]{4}", message = "định dang : MB-xxxx")

    @Column(unique = true)

    private String codeBank;
    @NotBlank
    private String startDay;
    @NotBlank
    private String endDay;
    @Size(min = 1, max = 4)
    @Pattern(regexp = "[0-9]+", message = "nhập sai định dạng")
    private String tenor;

    @NotNull
    @Range(min = 100000, max = 30000000, message = "tối thiểu là 100000 VND , tối đa 30000000")
    private Double deposits;

    private Customer customer;

    public BankDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeBank() {
        return codeBank;
    }

    public void setCodeBank(String codeBank) {
        this.codeBank = codeBank;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    public Double getDeposits() {
        return deposits;
    }

    public void setDeposits(Double deposits) {
        this.deposits = deposits;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BankDto bankDto = (BankDto) target;
        String year = bankDto.startDay;
        LocalDate yea1 = LocalDate.now();
        String year2 = yea1.toString();


    }
}
