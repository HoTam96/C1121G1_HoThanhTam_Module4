package com.example.model;

import javax.persistence.*;

@Entity(name = "feedBack")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "blog_id", referencedColumnName = "id")
    private BlogPicture blogPicture;
    private String client;
    private String feedBack;
    private Integer numberLike;

    public FeedBack() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BlogPicture getBlogPicture() {
        return blogPicture;
    }

    public void setBlogPicture(BlogPicture blogPicture) {
        this.blogPicture = blogPicture;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    public Integer getNumberLike() {
        return numberLike;
    }

    public void setNumberLike(Integer numberLike) {
        this.numberLike = numberLike;
    }
}
