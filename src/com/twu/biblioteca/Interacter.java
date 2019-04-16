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

    public PrintStream getPrintStream() {
        return printStream;
    }

    public Library getLibrary() {
        return library;
    }

    public void printWelcomeMessages(boolean includeOptionMenu) {
        this.printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        this.printStream.println("TEST");
        if(includeOptionMenu) {
            printOptionMessage();
        }
    }

    public void printOptionMessage() {
        this.printStream.println("\nPlease choose one of the following options:" +
                "\n0 : for quitting Biblioteca" +
                "\n1 : for displaying a List of Books" +
                "\n2 : for checking out a medium" +
                "\n3 : for returning a medium" +
                "\n4 : for displaying a List of Movies");
    }

    public boolean actOnChosenOption(Option option) {
        return option.execute(this);
    }

    public boolean processMenu() {
        Option option = userInputReader.readInputOptionFromUser();
        return actOnChosenOption(option);
    }

    public void handleMediumCheckout() {
        this.printStream.println("Please specify which medium you want to checkout (Title)");
        String mediumTitle = userInputReader.readInputMediumFromUser();
        if( this.library.containsAvailable(mediumTitle)) {
            this.library.checkout(mediumTitle);
            this.printStream.println("Thank you! Enjoy the medium");
        }
        else {
            this.printStream.println("Sorry, that medium is not available");
        }
        printOptionMessage();
    }

    public void handleMediumReturn() {
        this.printStream.println("Please specify which medium you want to return (Title)");
        String mediumTitle = userInputReader.readInputMediumFromUser();
        if( this.library.containsCheckedoutMedium(mediumTitle)) {
            this.library.returnMedium(mediumTitle);
            this.printStream.println("Thank you for returning the medium");
        }
        else {
            this.printStream.println("That is not a valid medium to return.");
        }
        printOptionMessage();
    }

}
