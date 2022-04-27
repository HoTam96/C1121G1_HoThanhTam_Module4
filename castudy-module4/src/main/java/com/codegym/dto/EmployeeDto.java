package com.codegym.dto;
import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Position;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EmployeeDto {

    @NotBlank(message = " tên không được để trống")
    @Pattern(regexp = "^$|(^[\\p{Lu}\\p{Ll}\\s]+$)")
    private String name;
    @NotBlank
    private String dateOfBirth;
    @NotBlank(message = "CMND không được để trống")
    @Pattern(regexp = "^$|(^(([0-9]{9})|([0-9]{12}))$)", message = "CMND phải đúng định dạng XXXXXXXXX hoặc XXXXXXXXXXXX ")
    private String idCard;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "(^$|(090|091|(\\+(84)90)|(\\+(84)91))([0-9]{7}))", message = "số điện thoại sai định dạng")
    private String phone;
    @NotBlank(message = "email không được để trống")
    private String email;
    private String address;
    private Boolean flag;
    private Integer id;
    @NotNull(message = "không được để trống")
    @Pattern(regexp = "^$|(([1-9](\\.?[0-9]+)?)|0\\.[1-9]+)")
    private String salary;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
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
