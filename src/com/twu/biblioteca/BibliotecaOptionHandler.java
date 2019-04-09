package com.twu.biblioteca;

public class BibliotecaOptionHandler {

    private BibliotecaLibrary library;

    public BibliotecaOptionHandler(BibliotecaLibrary library) {
        this.library = library;
    }

    public void actOnChosenOption(int option) {
        if( option == 1 ) {
            System.out.println("\nList of all library books (Title, Author, Year):\n");
            System.out.println(library.getListOfBooks());
        }
    }
}
