package com.workintech.library.models;


import com.workintech.library.enums.BookStatus;
import com.workintech.library.interfaces.BookOptions;

import java.time.LocalDateTime;

public class Book implements BookOptions {
    private long id;
    private Author author;
    private String name;
    private double price;
    private Member owner;
    private BookStatus status;
    private LocalDateTime dateOfPurchase;


    public Book(long id, Author author, String name, double price) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = BookStatus.AVAILABLE;
        this.dateOfPurchase = LocalDateTime.now();
    }

    @Override
    public void borrowItem(Member user) {
        if(user.canBorrow()) {
            this.status = BookStatus.BORROWED;
            this.owner = user;
            user.borrowBook();
            System.out.println(user.name + " borrowed this book: " + this.name);
        } else {
            System.out.println(user.name + "can't borrow this book: " + this.name);
        }
    }

    @Override
    public void returnItem() {
        if (status == BookStatus.BORROWED) {
            owner.returnBook();
            owner = null;
            status = BookStatus.AVAILABLE;
            System.out.println("The book is returned: " + this.name);
        }
    }



    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public BookStatus getStatus() {
        return status;
    }

    public LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }
}
