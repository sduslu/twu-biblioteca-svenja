package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {

        BibliotecaOutputWriter bOutputWriter = new BibliotecaOutputWriter();
        bOutputWriter.printWelcomeMessages(true);

        BibliotecaInputReader bInputReader = new BibliotecaInputReader();
        int option = bInputReader.readInputOptionFromUser();

        BibliotecaLibrary bLibrary = new BibliotecaLibrary();

        BibliotecaOptionHandler bOptionHandler = new BibliotecaOptionHandler(bLibrary);
        bOptionHandler.actOnChosenOption(option);
    }

}
