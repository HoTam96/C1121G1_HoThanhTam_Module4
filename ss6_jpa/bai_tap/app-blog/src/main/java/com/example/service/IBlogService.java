package com.example.service;

import com.example.model.BlogPicture;

import java.util.List;

public interface IBlogService {
    List<BlogPicture>findAll();
    List<BlogPicture>getListByCateId(Integer id);
}
