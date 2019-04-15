package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputReader {

    public Option readInputOptionFromUser() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            if (input.equals("0")) {
                return Option.OPTION_QUIT;
            } else if( input.equals("1") ) {
                return Option.OPTION_LIST_BOOKS;
            } else if( input.equals("2")) {
                return Option.OPTION_CHECKOUT;
            } else if( input.equals("3")) {
                return Option.OPTION_RETURN;
            } else if( input.equals("4")) {
                return Option.OPTION_LIST_MOVIES;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Option.OPTION_INVALID;
        } catch (NullPointerException n) {
//            n.printStackTrace();
            return Option.OPTION_INVALID;
        }
        return Option.OPTION_INVALID;
    }

    public String readInputMediumFromUser() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        try {
            input = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        return input;
    }
}
