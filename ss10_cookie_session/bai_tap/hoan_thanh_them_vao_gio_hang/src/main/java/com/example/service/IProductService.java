package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface IProductService {
    List<Product>findAll();
    Product findById(Integer id);
    void save(Product product);
    void delete(Integer id);


}
