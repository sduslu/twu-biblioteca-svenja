package com.twu.biblioteca;

public class BibliotecaOutputWriter {

    public static void printWelcomeMessages(boolean includeOptionMenu) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        if(includeOptionMenu) {
            System.out.println("\nPlease choose one of the following options:\n1 : for displaying a List of Books");
        }
    }
}
