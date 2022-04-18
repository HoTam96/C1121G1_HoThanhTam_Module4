package com.codegym.model.employee;

import com.codegym.model.Person;
import com.codegym.model.contract.Contract;
import com.codegym.model.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double salary;
    @ManyToOne
    @JoinColumn(name = "position_Id", referencedColumnName = "id")
    private Position position;
    @ManyToOne
    @JoinColumn(name = "educationDegreeId", referencedColumnName = "id")
    private EducationDegree educationDegree;
    @ManyToOne
    @JoinColumn(name = "divisionId", referencedColumnName = "id")
    private Division division;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_Nane",referencedColumnName = "userName")
    private User user;

    @OneToMany(mappedBy = "employee")
    private Set<Contract>contracts;

    public Employee() {
        setFlag(false);
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}