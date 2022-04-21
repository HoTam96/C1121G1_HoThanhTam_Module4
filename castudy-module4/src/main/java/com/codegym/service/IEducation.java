package com.codegym.service;

import com.codegym.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducation extends JpaRepository<EducationDegree,Integer> {
}
