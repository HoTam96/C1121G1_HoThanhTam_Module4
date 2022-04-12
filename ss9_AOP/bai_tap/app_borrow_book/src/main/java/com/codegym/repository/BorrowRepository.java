package com.codegym.repository;

import com.codegym.model.BorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepository extends JpaRepository<BorrowBook,Integer> {




}
