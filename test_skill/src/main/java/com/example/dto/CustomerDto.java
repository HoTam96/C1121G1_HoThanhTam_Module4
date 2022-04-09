package com.example.dto;

import com.example.model.Bank;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class CustomerDto implements Validator {

    private Integer id;
    @NotBlank
    @Pattern(regexp = "[A-Za-z ]+",message = "nhập sai định dạng")
    private String name;
    private Set<Bank> bankSet;
    public CustomerDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Bank> getBankSet() {
        return bankSet;
    }

    public void setBankSet(Set<Bank> bankSet) {
        this.bankSet = bankSet;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
