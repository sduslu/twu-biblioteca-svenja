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
                return Option.OPTION_QUIT;//0;
            } else if( input.equals("1") ) {
                return Option.OPTION_LIST_BOOKS;//1;
            } else if( input.equals("2")) {
                return Option.OPTION_CHECKOUT;//2;
            } else if( input.equals("3")) {
                return Option.OPTION_RETURN;//3;
            } else if( input.equals("4")) {
                return Option.OPTION_LIST_MOVIES;//3;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return Option.OPTION_INVALID;//-1;
        } catch (NullPointerException n) {
//            n.printStackTrace();
            return Option.OPTION_INVALID;//-1;
        }
        return Option.OPTION_INVALID;//-1;
    }

    public String readInputBookFromUser() {
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
