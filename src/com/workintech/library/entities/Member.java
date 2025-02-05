package com.workintech.library.entities;

public class Member {
    private long id;
    String name;
    String password;
    private int borrowedBooks;
    protected final int MAX_BOOKS;

    public Member(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.borrowedBooks = 0;
        this.MAX_BOOKS = 5;
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

    public boolean canBorrow() {
        return borrowedBooks < MAX_BOOKS;
    }

    public void borrowBook() {
        if(canBorrow()) {
            borrowedBooks++;
        } else {
            System.out.println("You have reached the maximum book borrowing limit.");
        }
    }

    public void returnBook() {
        if (borrowedBooks > 0) {
            borrowedBooks--;
        }
    }
}
