package com.example.service;

import com.example.model.BlogPicture;
import com.example.model.Category;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ICategoryService {

    List<Category> findAll();
    Category findById(Integer id);



}
