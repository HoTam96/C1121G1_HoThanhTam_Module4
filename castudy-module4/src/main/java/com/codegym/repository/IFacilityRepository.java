package com.codegym.repository;

import com.codegym.model.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Service,Integer> {
}
