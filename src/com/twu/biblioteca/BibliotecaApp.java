package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        System.out.println("\nList of all library books:\n");
        System.out.println(getListOfBooks());
    }

    public static String getListOfBooks() {
        String listOfBooks = new String("Alice in Wonderland\n");
        listOfBooks += "Charles Dickens\n";
        listOfBooks += "The Lord of the Rings\n";
        return listOfBooks;
    }
}
