package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");

        System.out.println("\nPlease choose one of the following options:\n1 : for displaying a List of Books");

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            if (input.equals("1")) {
                System.out.println("\nList of all library books (Title, Author, Year):\n");
                System.out.println(getListOfBooks());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
    }

    public static String getListOfBooks() {
        String listOfBooks = "Alice in Wonderland,Lewis Carrol,1865\n";
        listOfBooks += "Oliver Twist,Charles Dickens,1839\n";
        listOfBooks += "The Lord of the Rings,J. R. R. Tolkien,1954\n";
        return listOfBooks;
    }
}
