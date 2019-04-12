package com.twu.biblioteca;

import java.io.*;

public class Interacter {

    private Library library;
    private PrintStream printStream;
    private UserInputReader userInputReader;

    public Interacter(Library library, PrintStream printStream, UserInputReader userInputReader) {
        this.library = library;
        this.printStream = printStream;
        this.userInputReader = userInputReader;
    }

    public void printWelcomeMessages(boolean includeOptionMenu) {
        this.printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        this.printStream.println("TEST");
        if(includeOptionMenu) {
            printOptionMessage();
        }
    }

    private void printOptionMessage() {
        this.printStream.println("\nPlease choose one of the following options:" +
                "\n0 : for quitting Biblioteca" +
                "\n1 : for displaying a List of Books" +
                "\n2 : for checking out a book" +
                "\n3 : for returning a book");
    }

    public boolean actOnChosenOption(int option) {
        if( option == 0 ) {
            this.printStream.println("Exiting Biblioteca. See you soon!");
            return false;
        } else if( option == 1 ) {
            this.printStream.println("\nList of all library books (Title, Author, Year):\n");
            this.printStream.println(this.library.getListOfMediums(1));
            printOptionMessage();
        } else if( option == 2 ) {
            this.handleBookCheckout();
        } else if( option == 3 ) {
            this.handleBookReturn();
        }
        else if( option < 0 ) {
            this.printStream.println("Please select a valid option!");
        }
        return true;
    }

    public boolean processMenu() {
        int option = userInputReader.readInputOptionFromUser();
        return actOnChosenOption(option);
    }

    public void handleBookCheckout() {
        this.printStream.println("Please specify which book you want to checkout (Title)");
        String bookTitle = userInputReader.readInputBookFromUser();
        if( this.library.containsAvailable(bookTitle)) {
            this.library.checkout(bookTitle);
            this.printStream.println("Thank you! Enjoy the book");
        }
        else {
            this.printStream.println("Sorry, that book is not available");
        }
        printOptionMessage();
    }

    public void handleBookReturn() {
        this.printStream.println("Please specify which book you want to return (Title)");
        String bookTitle = userInputReader.readInputBookFromUser();
        if( this.library.containsCheckedoutBook(bookTitle)) {
            this.library.returnBook(bookTitle);
            this.printStream.println("Thank you for returning the book");
        }
        else {
            this.printStream.println("That is not a valid book to return.");
        }
        printOptionMessage();
    }

}
