package com.twu.biblioteca;

import java.io.PrintStream;

public enum Option {

    OPTION_QUIT {
        @Override
        boolean execute(Interacter interacter){
            interacter.getPrintStream().println("Exiting Biblioteca. See you soon!");
            return false;
        }
    },

    OPTION_LIST {
        @Override
        boolean execute(Interacter interacter){
            System.out.print("Executing listing");
            interacter.getPrintStream().println("\nList of all library books (Title, Author, Year):\n");
            interacter.getPrintStream().println(interacter.getLibrary().getListOfMediums(1));
            interacter.printOptionMessage();
            return true;
        }
    },

    OPTION_CHECKOUT {
        @Override
        boolean execute(Interacter interacter){
            interacter.handleBookCheckout();
            return true;
        }
    },

    OPTION_RETURN {
        @Override
        boolean execute(Interacter interacter){
            interacter.handleBookReturn();
            return true;
        }
    },

    OPTION_INVALID {
        @Override
        boolean execute(Interacter interacter){
            interacter.getPrintStream().println("Please select a valid option!");
            return true;
        }
    };

    abstract boolean execute(Interacter interacter);
}
