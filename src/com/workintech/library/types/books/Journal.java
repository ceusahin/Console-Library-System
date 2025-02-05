package com.workintech.library.types.books;

import com.workintech.library.entities.Author;
import com.workintech.library.entities.Book;
import com.workintech.library.enums.BookCategory;

public class Journal extends Book {
    public Journal(Author author, String name, double price, BookCategory category) {
        super(author, name, price, category);
    }
}
