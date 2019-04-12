package com.twu.biblioteca;

import java.io.*;

public class Interacter {

    private Library library;
    private PrintStream printStream;
    private InputStream inputStream;

    public Interacter(Library library, PrintStream printStream, InputStream inputStream) {
        this.library = library;
        this.printStream = printStream;
        this.inputStream = inputStream;
    }

    public Interacter(Library library) {
        this.library = library;
        this.printStream = System.out;
        this.inputStream = System.in;
    }

    public PrintStream getPrintStream() {
        return this.printStream;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public void printWelcomeMessages(boolean includeOptionMenu) {
        this.printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
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

    public static int readInputOptionFromUser() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            if (input.equals("0")) {
                return 0;
            } else if( input.equals("1") ) {
                return 1;
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
        if( option == 0 ) {
            this.printStream.println("Exiting Biblioteca. See you soon!");
            return false;
        } else if( option == 1 ) {
            this.printStream.println("\nList of all library books (Title, Author, Year):\n");
            this.printStream.println(this.library.getListOfBooks());
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

    public void handleBookCheckout() {
        this.printStream.println("Please specify which book you want to checkout (Title)");
        String bookTitle = readInputBookFromUser();
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
        String bookTitle = readInputBookFromUser();
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
