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
            return Option.fromUserInput(input);
        } catch (IOException e) {
            e.printStackTrace();
            return Option.OPTION_INVALID;
        } catch (NullPointerException n) {
//            n.printStackTrace();
            return Option.OPTION_INVALID;
        }
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
