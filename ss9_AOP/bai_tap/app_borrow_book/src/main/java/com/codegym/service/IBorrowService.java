package com.codegym.service;

import com.codegym.model.BorrowBook;

import java.util.List;

public interface IBorrowService {
    List<BorrowBook>findAll();
    BorrowBook findById(Integer id);
    void save(BorrowBook borrowBook);
}
