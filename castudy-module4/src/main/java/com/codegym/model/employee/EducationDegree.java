package com.codegym.model.employee;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String EducationDegreeName;
    @OneToMany(mappedBy = "educationDegree")
    private Set<Employee>employees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEducationDegreeName() {
        return EducationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        EducationDegreeName = educationDegreeName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
