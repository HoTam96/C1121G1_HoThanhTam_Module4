package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    @JsonBackReference
    List<BlogPicture> categorylist;


    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<BlogPicture> getCategorylist() {
        return categorylist;
    }

    public void setCategorylist(List<BlogPicture> categorylist) {
        this.categorylist = categorylist;
    }
}
