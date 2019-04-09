package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        System.out.println("\nList of all library books (Title, Author, Year):\n");
        System.out.println(getListOfBooks());
    }

    public static String getListOfBooks() {
        String listOfBooks = new String("Alice in Wonderland,Lewis Carrol,1865\n");
        listOfBooks += "Oliver Twist,Charles Dickens,1839\n";
        listOfBooks += "The Lord of the Rings,J. R. R. Tolkien,1954\n";
        return listOfBooks;
    }
}
