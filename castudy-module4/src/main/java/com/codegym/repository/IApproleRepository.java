package com.codegym.repository;

import com.codegym.model.user.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IApproleRepository extends JpaRepository<AppRole,Integer> {
}
