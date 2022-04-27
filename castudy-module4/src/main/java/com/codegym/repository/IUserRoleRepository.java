package com.codegym.repository;

import com.codegym.model.user.UserRole;
import com.codegym.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole,Integer> {
    List<UserRole>findByUser(AppUser user);


}
