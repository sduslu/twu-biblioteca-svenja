package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInputReader {

    public int readInputOptionFromUser() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            if (input.equals("0")) {
                return 0;
            } else if( input.equals("1") ) {
                return 1;
            } else if( input.equals("2")) {
                return 2;
            } else if( input.equals("3")) {
                return 3;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } catch (NullPointerException n) {
//            n.printStackTrace();
            return -1;
        }
        return -1;
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
