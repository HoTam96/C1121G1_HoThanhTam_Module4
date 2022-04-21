package com.codegym.dto;
import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Position;
import com.codegym.model.user.User;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class EmployeeDto {
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
    private Double salary;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    @Valid
    private UserDto userDto;

    public EmployeeDto() {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
