package com.workintech.library.entities;

import com.workintech.library.enums.BookCategory;

import java.util.*;

public class BookList {
    private long id = 1;
    private Map<Long, Book> books;

    public BookList() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book, Author author) {
        books.put(id++, book);
        author.addBookToAuthor(book);
    }

    public void removeBookById(long id) {
        if (!books.containsKey(id)) {
            System.out.println("Book not found with ID: " + id);
            return;
        }

        Book book = books.get(id);
        Author author = book.getAuthor();

        books.remove(id);

        if (author != null) {
            author.getBooks().remove(book);
        }

        System.out.println("Book removed successfully: " + book.getName());
    }

    public Map<Long, Book> getAllBooks() {
        return books;
    }

    public Book searchById(long id) {
        return books.get(id);
    }

    public Book searchByName(String name) {
        for (Book book : books.values()) {
            if (book.getName().equalsIgnoreCase(name)) {
                return book;
            }
        }
        return null;
    }

    public void listByCategory(BookCategory category) {
        List<Book> booksByCategory = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getCategory().equals(category)) {
                booksByCategory.add(book);
            }
        }

        if (!booksByCategory.isEmpty()) {
            System.out.println("Books in category: " + category);
            for (Book book : booksByCategory) {
                System.out.println("ID: " + getBookId(book) + " - Name: " + book.getName() + " - Author: " + book.getAuthor().getName());
            }
        } else {
            System.out.println("No books found in category: " + category);
        }
    }

    private Long getBookId(Book book) {
        for (Map.Entry<Long, Book> entry : books.entrySet()) {
            if (entry.getValue().equals(book)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<Book> listByAuthor(Author author) {
        List<Book> booksByAuthor = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }

        return booksByAuthor.isEmpty() ? null : booksByAuthor;
    }

    public void displayBooksByAuthor(Author author) {
        List<Book> booksByAuthor = listByAuthor(author);

        if (booksByAuthor != null && !booksByAuthor.isEmpty()) {
            System.out.println("Author's books: ");
            for (Book book : booksByAuthor) {
                System.out.println("ID: " + (booksByAuthor.indexOf(book) + 1) + " - Book: " + book.getName());
            }

            System.out.print("Please choose an ID: ");
            Scanner scanner = new Scanner(System.in);
            int selectedId = scanner.nextInt();

            if (selectedId > 0 && selectedId <= booksByAuthor.size()) {
                Book selectedBook = booksByAuthor.get(selectedId - 1);
                System.out.println("Selected Book: " + selectedBook.getName() + " - Author: " + selectedBook.getAuthor().getName());
            } else {
                System.out.println("Invalid ID. Please choose a valid ID.");
            }
        } else {
            System.out.println("No books found by this author.");
        }
    }
}
