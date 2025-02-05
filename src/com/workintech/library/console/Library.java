package com.workintech.library.console;


import com.workintech.library.entities.*;
import com.workintech.library.enums.BookCategory;
import com.workintech.library.types.members.Faculty;
import com.workintech.library.types.members.Student;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Library {
    private static Librarian librarian;
    public static BookList bookList = new BookList();
    public static Set<Author> authors = new HashSet<>();
    public static Set<Member> members = new HashSet<>();
    public static VerifyMember verifyMember = new VerifyMember(members);
    private static Member currentUser = null;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inp;

        while (true){
            if(currentUser == null) {
                System.out.println("Welcome to CEU Library.");
                System.out.println("Please choose an option.");
                System.out.println("1- Register (Sign Up)");
                System.out.println("2- Login");
                System.out.println("3- Exit");

                int inpLogin = input.nextInt();
                input.nextLine();

                switch (inpLogin) {
                    case 1:
                        registerMember();
                        break;
                    case 2:
                        loginMember();
                        break;
                    case 3:
                        System.out.println("Exiting the library...");
                        return;
                    case 4:
                        verifyMember.displayMembers();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } else {
                System.out.println("Welcome to CEU Library.");
                System.out.println("Please choose an option.");
                System.out.println("1-  ADD NEW BOOK"); // +
                System.out.println("2-  FIND A BOOK"); // +
                System.out.println("3-  UPDATE BOOK INFOS"); // +
                System.out.println("4-  REMOVE A BOOK"); // +
                System.out.println("5-  LIST ALL BOOKS"); // +
                System.out.println("6-  EXIT THE LIBRARY"); // +

                inp = input.nextInt();
                input.nextLine();

                switch (inp){
                    case 1:
                        System.out.println("What type of book would you like to add?");
                        System.out.println("1-  Journal");
                        System.out.println("2-  Study");
                        System.out.println("3-  Magazine");
                        int inpCase1 = input.nextInt();
                        input.nextLine();

                        System.out.println("Enter book's name: ");
                        String bookName = input.nextLine();

                        System.out.println("Enter author's name: ");
                        String authorName = input.nextLine();

                        System.out.println("Enter book's price: ");
                        double bookPrice = input.nextDouble();

                        Author author = getAuthorByName(authorName);

                        if (author == null) {
                            author = new Author(authorName);
                            authors.add(author);
                            System.out.println("New author added: " + authorName);
                        }

                        BookCategory category = null;
                        switch (inpCase1){
                            case 1:
                                category = BookCategory.JOURNAL;
                                break;
                            case 2:
                                category = BookCategory.STUDY;
                                break;
                            case 3:
                                category = BookCategory.MAGAZINE;
                                break;
                            default:
                                System.out.println("Invalid option!");
                                break;
                        }

                        Book book = new Book(author, bookName, bookPrice, category);

                        bookList.addBook(book, author);
                        System.out.println("Book added successfully.");

                        System.out.println("--------------------------");
                        break;
                    case 2:
                        // id name ve author'a göre kitap seçilecek.
                        System.out.println("Which method do you use to choose books?");
                        System.out.println("1-  Search by ID.");
                        System.out.println("2-  Search by name.");
                        System.out.println("3-  Search by author.");
                        int inpCase2 = input.nextInt();
                        input.nextLine();

                        switch (inpCase2){
                            case 1:
                                System.out.println("Enter the ID number of the book you are looking for.");
                                int inpCase2Id = input.nextInt();
                                input.nextLine();
                                Book foundedBook = bookList.searchById(inpCase2Id);
                                System.out.println(foundedBook.toString());
                                break;
                            case 2:
                                System.out.println("Enter the name of the book you are looking for.");
                                String inpCase2Name = input.nextLine();
                                bookList.searchByName(inpCase2Name);
                                break;
                            case 3:
                                System.out.println("Enter the author's name of the book you are looking for.");
                                String inpCase2Author = input.nextLine();
                                Author author2 = getAuthorByName(inpCase2Author);
                                bookList.displayBooksByAuthor(author2);
                                break;
                        }

                        System.out.println("--------------------------");
                        break;
                    case 3:
                        System.out.println("Enter the ID number of the book you want to update.");
                        long inpCase3Id = input.nextInt();

                        Book case3Book = bookList.searchById(inpCase3Id);

                        System.out.println("Which feature do you want to update?");
                        System.out.println("1-  Book's name"); // name
                        System.out.println("2-  Book's author"); // author
                        System.out.println("3-  Book's category"); // category
                        System.out.println("4-  Book's price"); // price

                        int inpCase3Option = input.nextInt();
                        input.nextLine();

                        switch (inpCase3Option) {
                            case 1:
                                System.out.println("What would you like to name the book?");
                                String currentName = case3Book.getName();
                                String updateName = input.nextLine();
                                case3Book.setName(updateName);
                                System.out.println("Book's Old Name: " + currentName + " <<>> " + "Book's Updated Name: " + case3Book.getName());
                                break;
                            case 2:
                                System.out.println("What would you like to author's name of the book?");
                                String updateAuthorName = input.nextLine();
                                Author case3Author = case3Book.getAuthor();
                                Author case3AuthorNew = case3Book.getAuthor();
                                case3AuthorNew.setName(updateAuthorName);
                                System.out.println("Book's Current Author's Name: " + case3Author + " <<>> " + "Book's Updated Author's Name: " + case3Book.getAuthor().getName());
                                break;
                            case 3:
                                System.out.println("What would you like to category of the book?");
                                System.out.println("1-  Journal");
                                System.out.println("2-  Study");
                                System.out.println("3-  Magazine");
                                int case3CategorySelection = input.nextInt();
                                BookCategory case3BookOldCategory = case3Book.getCategory();
                                BookCategory case3BookCategory = null;
                                switch (case3CategorySelection) {
                                    case 1:
                                        case3BookCategory = BookCategory.JOURNAL;
                                        break;
                                    case 2:
                                        case3BookCategory = BookCategory.STUDY;
                                        break;
                                    case 3:
                                        case3BookCategory = BookCategory.MAGAZINE;
                                        break;
                                }

                                case3Book.setCategory(case3BookCategory);
                                System.out.println("Book's Old Category: " + case3BookOldCategory + " <<>> " + "Book's Updated Category: " + case3Book.getCategory());
                                break;
                            case 4:
                                System.out.println("What would you like to book's price?");
                                double newPrice = input.nextDouble();
                                double oldPrice = case3Book.getPrice();
                                case3Book.setPrice(newPrice);
                                System.out.println("Book's Old Price: " + oldPrice + " <<>> " + "Book's Updated Price: " + case3Book.getPrice());
                                break;
                            default:
                                System.out.println("Please enter a valid option.");
                                break;
                        }


                        System.out.println("--------------------------");
                        break;
                    case 4:
                        // remove a book
                        System.out.println("Enter the ID of the book you want to remove.");

                        long inpCase4 = input.nextLong();
                        input.nextLine();

                        bookList.removeBookById(inpCase4);

                        System.out.println("--------------------------");
                        break;
                    case 5:
                        // list all books by author, list all books by categories
                        System.out.println("Which option do you want to list the books by?");
                        System.out.println("1-  List all books by category.");
                        System.out.println("2-  List all books by author.");

                        int inpCase5 = input.nextInt();
                        input.nextLine();

                        switch (inpCase5) {
                            case 1:
                                System.out.println("Which category do you want to list?");
                                System.out.println("1-  Magazine");
                                System.out.println("2-  Study");
                                System.out.println("3-  Journal");
                                int inpCase5Category = input.nextInt();
                                input.nextLine();

                                BookCategory selectedCategory = null;

                                switch (inpCase5Category) {
                                    case 1:
                                        selectedCategory = BookCategory.MAGAZINE;
                                        break;
                                    case 2:
                                        selectedCategory = BookCategory.STUDY;
                                        break;
                                    case 3:
                                        selectedCategory = BookCategory.JOURNAL;
                                        break;
                                    default:
                                        System.out.println("Invalid option! Please select a valid category.");
                                        break;
                                }

                                if (selectedCategory != null) {
                                    bookList.listByCategory(selectedCategory);
                                }
                                break;
                            case 2:
                                System.out.println("Enter the author's name.");
                                String inpCase5Author = input.nextLine();
                                Author author2 = getAuthorByName(inpCase5Author);
                                bookList.displayBooksByAuthor(author2);
                                break;
                        }

                        System.out.println("--------------------------");
                        break;
                    case 6:
                        System.out.println("--------------------------");
                        System.out.println("Logging out...");
                        System.out.println("--------------------------");
                        currentUser = null;
                        return;
                }
            }


        }
    }

    public static void registerMember() {
        Scanner input = new Scanner(System.in);

        int userId = 1;
        System.out.println("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Enter your password: ");
        String password = input.nextLine();

        System.out.println("Please select member type.");
        System.out.println("1-  Student");
        System.out.println("2-  Faculty");
        int type = input.nextInt();

        Member newMember = null;
        if (type == 1) {
            newMember = new Student(userId, name, password);
            userId++;
        } else if (type == 2) {
            newMember = new Faculty(userId, name, password);
            userId++;
        } else {
            System.out.println("Invalid member type.");
            return;
        }

        members.add(newMember);
        System.out.println("Registration successful. Your member ID is: " + newMember.getId());
    }

    public static void loginMember() {
        Scanner input = new Scanner(System.in);
        VerifyMember verifyMember = new VerifyMember(members);

        System.out.println("Enter your member ID: ");
        long id = input.nextLong();
        input.nextLine();

        System.out.println("Enter your password: ");
        String password = input.nextLine();

        for (Member member : members) {
            if (member.getId() == id && member.getPassword().equals(password)) {
                currentUser = member;
                System.out.println("Login successful. Welcome, " + member.getName() + "!");
                return;
            }
        }

        System.out.println("Login failed. Please try again.");
    }

    private static Author getAuthorByName(String name) {
        for (Author author : authors) {
            if (author.getName().equalsIgnoreCase(name)) {
                return author;
            }
        }
        return null;
    }
}
