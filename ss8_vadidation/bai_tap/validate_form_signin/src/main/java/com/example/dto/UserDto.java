package com.example.dto;

import net.bytebuddy.build.Plugin;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


@Component
public class UserDto implements Validator {

    private Integer id;
    @NotBlank(message = "please input first name")
    @Pattern(regexp = "[A-Z-a-z]+",message = "name wrong format")
    private String firstName;
    @NotBlank(message = "please input last name")
    @Pattern(regexp = "[A-Z-a-z]+",message = "name wrong format")
    private String lastName;
    @Pattern(regexp = "[0-9]{9}")
    private String phone;
    private String dateOfBirth;
    @Email(message = "email wrong format")
    private String email;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        Integer year = Integer.parseInt(userDto.getDateOfBirth().substring(0,4));

            Integer currentYear = LocalDate.now().getYear();

            if (currentYear-year<18){
                errors.rejectValue("dateOfBirth","user.not113","tuổi không được nhỏ hơn 18");
            }

        }



    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
