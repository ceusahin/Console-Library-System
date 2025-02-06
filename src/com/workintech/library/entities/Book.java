package com.workintech.library.entities;


import com.workintech.library.enums.BookCategory;
import com.workintech.library.enums.BookStatus;
import com.workintech.library.interfaces.BookOptions;

import java.time.LocalDateTime;

public class Book implements BookOptions {
    private Author author;
    private String name;
    private double price;
    private BookStatus status;
    private BookCategory category;
    private LocalDateTime dateOfPurchase;
    private Member owner;

    public Book(Author author, String name, double price, BookCategory category) {
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = BookStatus.AVAILABLE;
        this.category = category;
        this.dateOfPurchase = LocalDateTime.now();
    }

    @Override
    public void borrowBook(Member user) {
        if (user.canBorrow(this)) {
            this.status = BookStatus.BORROWED;
            this.owner = user;
            user.getBorrowedBooks().add(this);
            user.setBorrowedBooksNum(user.getBorrowedBooksNum() + 1);
            System.out.println(user.getName() + " borrowed this book: " + this.name);
        } else {
            System.out.println(user.getName() + " can't borrow this book: " + this.name);
        }
    }

    @Override
    public void returnBook() {
        if (status == BookStatus.BORROWED && owner != null) {
            owner.getBorrowedBooks().remove(this);
            owner.setBorrowedBooksNum(owner.getBorrowedBooksNum() - 1);
            System.out.println(owner.getName() + " returned the book: " + this.name);
            owner = null;
            status = BookStatus.AVAILABLE;
        } else {
            System.out.println("This book is not borrowed or has no owner.");
        }
    }

    public BookCategory getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public Member getOwner() {
        return owner;
    }

    public void setOwner(Member owner) {
        this.owner = owner;
    }

    public LocalDateTime getDateOfPurchase() {
        return dateOfPurchase;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author = " + author.toString() +
                ", name = " + name +
                ", price = " + price +
                ", status = " + status +
                ", category = " + category +
                ", dateOfPurchase = " + dateOfPurchase +
                ", owner = " + owner.getName() +
                '}';
    }
}
