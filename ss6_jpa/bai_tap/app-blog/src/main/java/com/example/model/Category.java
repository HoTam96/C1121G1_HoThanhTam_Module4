package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String CategoryName;
    @OneToMany(mappedBy = "category")
    List<BlogPicture> Categorylist;


    public Category() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public List<BlogPicture> getCategorylist() {
        return Categorylist;
    }

    public void setCategorylist(List<BlogPicture> categorylist) {
        Categorylist = categorylist;
    }
}
