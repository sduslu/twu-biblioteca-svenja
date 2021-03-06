package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    //Streams for testing the command line outputs:
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testIntegrationBibliotecaApp() {
        //Given
        //When
        //Then
    }

/*    TODO make this test work. Problem: Multiple user inputs.
 @Test
    public void testOptionMenuListOfBooks() {
        //Given

        //When
        ByteArrayInputStream in;
        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        BibliotecaApp.main(new String[1]);

        //Then
        String expectedWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\n";
        String expectedOptionMessage = "Please choose one of the following options:" +
                "\n0 : for quitting Biblioteca" +
                "\n1 : for displaying a List of Books\n";
        String expectedListTitle = "\nList of all library books (Title, Author, Year):\n\n";
        Library library = new Library();
        String expectedListOfBooks = library.getListOfBooks();

        assertEquals( expectedWelcomeMessage+expectedOptionMessage+expectedListTitle+expectedListOfBooks+"\n",
                outContent.toString());

        //Teardown
        System.setIn(System.in);
    }*/


   /* TODO make this test work
   @Test
    public void testReenterChoiceAfterInvalidChoice() {
        //Given: As a user
        //When: I enter an invalid choice
        String simulatedUserInput = "-3" + System.getProperty("line.separator")
                + "1" + System.getProperty("line.separator");
        ByteArrayInputStream in;
        in = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(in);
        BibliotecaApp.main(new String[1]);

        //Then: I want to be able to enter another choice
        String expectedWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\n";
        String expectedOptionMessage = "Please choose one of the following options:\n1 : for displaying a List of Books\n";
        String expectedInvalidMessage = "Please select a valid option!\n";
        String expectedListTitle = "\nList of all library books (Title, Author, Year):\n\n";
        Library library = new Library();
        String expectedListOfBooks = library.getListOfBooks();

        assertEquals( expectedWelcomeMessage+expectedOptionMessage+expectedInvalidMessage+expectedListTitle+
                        expectedListOfBooks+"\n",
                outContent.toString());

        //Teardown
        System.setIn(System.in);
    }*/
}
