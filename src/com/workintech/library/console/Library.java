package com.workintech.library.console;


import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inp;

        while (true){
            System.out.println("Welcome to CEU'Library.");
            System.out.println("Please choose an option.");
            System.out.println("1-  ADD NEW BOOK");
            System.out.println("2-  FIND A BOOK");
            System.out.println("3-  UPDATE BOOK INFOS");
            System.out.println("4-  REMOVE A BOOK");
            System.out.println("5-  LIST ALL BOOKS BY CATEGORIES");
            System.out.println("6-  LIST ALL BOOKS BY AUTHOR");
            System.out.println("7-  EXIT THE LIBRARY");

            inp = input.nextInt();

            switch (inp){
                case 1:
                    System.out.println("What type of book would you like to add?");
                    System.out.println("1-  Journal");
                    System.out.println("2-  Study");
                    System.out.println("3-  Magazine");
                    int inp2 = input.nextInt();
                    switch (inp2){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Exiting the library...");
                    return;
            }

        }
    }
}
