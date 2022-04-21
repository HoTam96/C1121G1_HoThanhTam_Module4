package com.codegym.dto;

import com.codegym.model.employee.Employee;
import com.codegym.model.user.UseRole;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

public class UserDto {

    private String userName;
    private String passWord;

    public UserDto() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
