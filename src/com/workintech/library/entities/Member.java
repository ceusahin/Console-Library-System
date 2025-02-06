package com.workintech.library.entities;

import com.workintech.library.enums.BookStatus;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private long id;
    String name;
    String password;
    private int borrowedBooksNum;
    protected final int MAX_BOOKS;
    private List<Book> borrowedBooks;

    public Member(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.borrowedBooksNum = 0;
        this.MAX_BOOKS = 5;
        this.borrowedBooks = new ArrayList<>();
    }

    public boolean verifyPassword (String inpPassword) {
        return this.password.equals(inpPassword);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Member{" +
                "borrowedBooks=" + borrowedBooks +
                '}';
    }

    public int getBorrowedBooksNum() {
        return borrowedBooksNum;
    }

    public void setBorrowedBooksNum(int borrowedBooksNum) {
        this.borrowedBooksNum = borrowedBooksNum;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public boolean canBorrow(Book book) {
        return borrowedBooksNum < MAX_BOOKS && book.getStatus() == BookStatus.AVAILABLE;
    }
}
