package com.example.repository;


import com.example.model.BlogPicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IBlogRepository extends JpaRepository<BlogPicture,Integer> {

}
