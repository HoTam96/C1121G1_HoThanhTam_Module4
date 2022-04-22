package com.codegym.repository;

import com.codegym.model.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRenTypeRepository extends JpaRepository<RentType,Integer> {
}
