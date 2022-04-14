package com.example.repository;


import com.example.model.BlogPicture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IBlogRepository extends JpaRepository<BlogPicture,Integer> {
    Page<BlogPicture>findAllByAuthorContaining(String name, Pageable pageable);

    @Query(value = "select b from blog b where b.category.id = :id")
    Page<BlogPicture>findAllByCategoryId(@Param("id") Integer id, Pageable pageable);


}
