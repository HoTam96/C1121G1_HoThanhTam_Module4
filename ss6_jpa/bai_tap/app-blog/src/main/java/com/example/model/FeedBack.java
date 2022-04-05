package com.example.model;

import javax.persistence.*;

@Entity(name = "feedBack")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "blog_id" , referencedColumnName = "id")
    private BlogPicture blogPicture;
    private String client;
    private String feedBack;
    private Integer numberLike;
}
