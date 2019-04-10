package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library library = new Library();
        Interacter interacter = new Interacter(library);

        interacter.printWelcomeMessages(true);

        boolean keepGoing = true;
        int tries = 0;

        while( keepGoing && tries < 10 ) {
            keepGoing = ! interacter.processMenu();

        }
    }


}
