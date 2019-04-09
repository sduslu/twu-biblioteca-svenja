package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BibliotecaInputReader {

    public static int readInputOptionFromUser() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            String input = reader.readLine();
            if (input.equals("1")) {
                return 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException n) {
            n.printStackTrace();
        }
        return 0;
    }
}
