package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interacter {

    Library library;

    public Interacter(Library library) {
        this.library = library;
    }

    public static void printWelcomeMessages(boolean includeOptionMenu) {
        System.out.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
        if(includeOptionMenu) {
            System.out.println("\nPlease choose one of the following options:\n1 : for displaying a List of Books");
        }
    }

    public static int readInputOptionFromUser() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            if (input.equals("1")) {
                return 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        return 0;
    }

    public void actOnChosenOption(int option) {
        if( option == 1 ) {
            System.out.println("\nList of all library books (Title, Author, Year):\n");
            System.out.println(this.library.getListOfBooks());
        }
    }
}
