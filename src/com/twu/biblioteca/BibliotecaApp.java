package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        Library library = new Library();
        UserInputReader userInputReader = new UserInputReader();
        Interacter interacter = new Interacter(library, System.out, userInputReader);

        interacter.printWelcomeMessages(true);

        boolean keepGoing = true;

        while( keepGoing ) {
            keepGoing = interacter.processMenu();
        }
    }


}
