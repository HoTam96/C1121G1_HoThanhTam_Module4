package com.codegym.service;

import com.codegym.model.Book;

import java.util.List;

public interface IBookService {
    List<Book>findAll();
    Book findById(Integer id);
    void save(Book book);
}
