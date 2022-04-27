package com.codegym.repository;

import com.codegym.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByUserName (String userName);
}
