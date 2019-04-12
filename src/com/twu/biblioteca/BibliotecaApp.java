package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library library = new Library();
        Interacter interacter = new Interacter(library, System.out, System.in);

        interacter.printWelcomeMessages(true);

        boolean keepGoing = true;

        while( keepGoing ) {
            keepGoing = interacter.processMenu();
        }
    }


}
