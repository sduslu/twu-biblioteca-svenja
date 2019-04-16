package com.twu.biblioteca;

public enum Option {


    OPTION_QUIT("0") {
        @Override
        boolean execute(Interacter interacter){
            interacter.getPrintStream().println("Exiting Biblioteca. See you soon!");
            return false;
        }
    },

    OPTION_LIST_BOOKS("1") {
        @Override
        boolean execute(Interacter interacter){
            interacter.getPrintStream().println("\nList of all library books (Title, Author, Year):\n");
            interacter.getPrintStream().println(interacter.getLibrary().getListOfMediums(1));
            interacter.printOptionMessage();
            return true;
        }
    },

    OPTION_LIST_MOVIES("4") {
        @Override
        boolean execute(Interacter interacter){
            interacter.getPrintStream().println("\nList of all library movies (Title, Director, Rating, Year):\n");
            interacter.getPrintStream().println(interacter.getLibrary().getListOfMediums(2));
            interacter.printOptionMessage();
            return true;
        }
    },

    OPTION_CHECKOUT("2") {
        @Override
        boolean execute(Interacter interacter){
            interacter.handleMediumCheckout();
            return true;
        }
    },

    OPTION_RETURN("3") {
        @Override
        boolean execute(Interacter interacter){
            interacter.handleMediumReturn();
            return true;
        }
    },

    OPTION_INVALID("-1") {
        @Override
        boolean execute(Interacter interacter){
            interacter.getPrintStream().println("Please select a valid option!");
            return true;
        }
    };

    String inputNumber;

    Option(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    static Option fromUserInput(String inputNumber) {
        for( Option option : Option.values() ) {
            if( inputNumber.equals(option.inputNumber))
                return option;
        }
        return OPTION_INVALID;
    }

    abstract boolean execute(Interacter interacter);

}
