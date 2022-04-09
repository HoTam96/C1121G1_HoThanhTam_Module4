package com.example.dto;

import com.example.model.Bank;
import com.example.model.Customer;
import com.example.repository.IBankRepository;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankDto implements Validator {
    public static final String DATE_YYYY_MM_DD = "^\\d{4}[\\-\\/\\s]?((((0[13578])|(1[02]))[\\-\\/\\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\\-\\/\\s]?(([0-2][0-9])|(30)))|(02[\\-\\/\\s]?[0-2][0-9]))$";
    @Autowired
    private IBankRepository iBankRepository;

    private Integer id;
    @Pattern(regexp = "(MB-)[0-9]{4}", message = "định dang : MB-xxxx")
    @Column(unique = true)
    private String codeBank;
    @NotBlank
    private String startDay;
    @Size(min = 1, max = 4)
    @Pattern(regexp = "[0-9]+", message = "nhập sai định dạng")
    private String tenor;

    @NotNull
    @Range(min = 1, max = 30000000, message = "tối thiểu là 100000 VND , tối đa 30000000")
    private Double deposits;
   @Valid
    private CustomerDto customer;

    public BankDto() {
    }

    public IBankRepository getiBankRepository() {
        return iBankRepository;
    }

    public void setiBankRepository(IBankRepository iBankRepository) {
        this.iBankRepository = iBankRepository;
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

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BankDto bankDto = (BankDto) target;
        if (bankDto.getStartDay().matches(DATE_YYYY_MM_DD)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate now = LocalDate.now();
            LocalDate date = LocalDate.parse(bankDto.getStartDay(), formatter);
            if (date.isBefore(now)) {
                errors.rejectValue("startDay", "time.before", "ngày quá khứ");

            }

        }
    }
}
