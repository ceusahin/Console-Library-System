package com.workintech.library.entities;

public class Member {
    private long id;
    String name;
    private int borrowedBooks;
    protected final int MAX_BOOKS;

    public Member(long id, String name, int MAX_BOOKS) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = 0;
        this.MAX_BOOKS = MAX_BOOKS;
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
