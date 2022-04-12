package com.codegym.service.impl;

import com.codegym.model.BorrowBook;
import com.codegym.repository.BorrowRepository;
import com.codegym.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    @Override
    public List<BorrowBook> findAll() {
        return borrowRepository.findAll();
    }

    @Override
    public BorrowBook findById(Integer id) {
        return borrowRepository.findById(id).get();
    }

    @Override
    public void save(BorrowBook borrowBook) {
        borrowRepository.save(borrowBook);
    }
}
