package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library library = new Library();
        Interacter interacter = new Interacter(library);

        interacter.printWelcomeMessages(true);

        int option = interacter.readInputOptionFromUser();

        interacter.actOnChosenOption(option);
    }

}
