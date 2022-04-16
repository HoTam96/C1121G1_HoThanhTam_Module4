package com.example.service;

import com.example.model.BlogPicture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    public Page<BlogPicture> findAll(String keyWord , Pageable pageable);
    public Page<BlogPicture> findByCategoryId(Integer id , Pageable pageable);
    List<BlogPicture>getListByCateId(Integer id);
    void save(BlogPicture blogPicture);
     BlogPicture getBlogById(Integer id);
     void update(BlogPicture blogPicture);
     void delete(Integer id);


}
