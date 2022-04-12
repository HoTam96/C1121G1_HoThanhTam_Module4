package com.codegym.model;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameBook;
    private String author;
    private String amount;
    private String status;
    @OneToMany(mappedBy = "book")
    private Set<BorrowBook>borrowBookSet;
    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<BorrowBook> getBorrowBookSet() {
        return borrowBookSet;
    }

    public void setBorrowBookSet(Set<BorrowBook> borrowBookSet) {
        this.borrowBookSet = borrowBookSet;
    }
}
