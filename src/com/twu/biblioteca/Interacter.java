package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interacter {

    private Library library;

    public Interacter(Library library) {
        this.library = library;
    }

    public static void printWelcomeMessages(boolean includeOptionMenu) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        if(includeOptionMenu) {
            printOptionMessage();
        }
    }

    private static void printOptionMessage() {
        System.out.println("\nPlease choose one of the following options:" +
                "\n0 : for quitting Biblioteca" +
                "\n1 : for displaying a List of Books" +
                "\n2 : for checking out a book" +
                "\n3 : for returning a book");
    }

    public static int readInputOptionFromUser() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            if (input.equals("1")) {
                return 1;
            } else if( input.equals("0") ) {
                return 0;
            } else if( input.equals("2")) {
                return 2;
            } else if( input.equals("3")) {
                return 3;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        return -1;
    }

    public boolean actOnChosenOption(int option) {
        if( option == 1 ) {
            System.out.println("\nList of all library books (Title, Author, Year):\n");
            System.out.println(this.library.getListOfBooks());
            printOptionMessage();
        } else if( option == 0 ) {
            System.out.println("Exiting Biblioteca. See you soon!");
            return false;
        } else if( option == 2 ) {
            System.out.println("Please specify which book you want to checkout (Title)");
            String bookTitle = readInputBookFromUser();
            if( this.library.containsAvailable(bookTitle)) {
                this.library.checkout(bookTitle);
                System.out.println("Thank you! Enjoy the book");
            }
            else {
                System.out.println("Sorry, that book is not available");
            }
            printOptionMessage();
        } else if( option == 3 ) {
            System.out.println("Please specify which book you want to return (Title)");
            String bookTitle = readInputBookFromUser();
            if( this.library.containsCheckedoutBook(bookTitle)) {
                this.library.returnBook(bookTitle);
                System.out.println("Thank you! Enjoy the book");
            }
            else {
                System.out.println("Sorry, that book is not available");
            }
            printOptionMessage();
        }
        else if( option < 0 ) {
            System.out.println("Please select a valid option!");
        }
        return true;
    }

    public boolean processMenu() {
        int option = readInputOptionFromUser();
        return actOnChosenOption(option);
    }

    public static String readInputBookFromUser() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        return input;
    }
}
