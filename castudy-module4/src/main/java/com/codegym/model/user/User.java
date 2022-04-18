package com.codegym.model.user;

import com.codegym.model.employee.Employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
public class User{
    @Id
    private String userName;
    private String passWord;
    @OneToMany(mappedBy = "user")
    private Set<Employee> employees;
    @OneToMany(mappedBy = "user")
    private Set<UseRole> useRoles;

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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<UseRole> getUseRoles() {
        return useRoles;
    }

    public void setUseRoles(Set<UseRole> useRoles) {
        this.useRoles = useRoles;
    }
}
