package com.workintech.library.entities;

public class Librarian {
    private String name;
    private String password;
    private BookList bookList;

    public Librarian(String name, String password, BookList bookList) {
        this.name = name;
        this.password = password;
        this.bookList = bookList;
    }
}
