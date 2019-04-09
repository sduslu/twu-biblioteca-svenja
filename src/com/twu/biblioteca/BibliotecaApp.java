package com.twu.biblioteca;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        System.out.println("\nPlease choose one of the following options:\n1 : for displaying a List of Books");

        Scanner in = new Scanner(System.in);
        try {
            int a = in.nextInt();
            if (a == 1) {
                System.out.println("\nList of all library books (Title, Author, Year):\n");
                System.out.println(getListOfBooks());
            }
        }catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public static String getListOfBooks() {
        String listOfBooks = "Alice in Wonderland,Lewis Carrol,1865\n";
        listOfBooks += "Oliver Twist,Charles Dickens,1839\n";
        listOfBooks += "The Lord of the Rings,J. R. R. Tolkien,1954\n";
        return listOfBooks;
    }
}
