package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InteracterTest {


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
    public void testSimpleWelcomeMessage() {
        //Given: As a user

        //When: I start the application
        Interacter.printWelcomeMessages(false);

        //Then: I want to see a welcome message
        String expectedWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        assertEquals( expectedWelcomeMessage,
                outContent.toString());
    }

    @Test
    public void testWelcomeMessageWithBookList() {
        //Given: As a user

        //When: After the welcome message appears
        Interacter.printWelcomeMessages(true);

        //Then: I want to see a menu of options before the list of all library books
        String expectedWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\n";
        String expectedOptionMessage = "Please choose one of the following options:\n1 : for displaying a List of Books\n";
        assertEquals( expectedWelcomeMessage+expectedOptionMessage,
                outContent.toString());
    }

    @Test
    public void testReadInputOptionFromUser() {
        //Given
        //When
        ByteArrayInputStream in;
        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        //Then
        assertEquals(1, Interacter.readInputOptionFromUser());
        //Teardown
        System.setIn(System.in);
    }

    @Test
    public void testReadInvalidInputOptionFromUser() {
        //Given: As a user
        //When: I supply invalid input
        ByteArrayInputStream in;
        in = new ByteArrayInputStream("A".getBytes());
        System.setIn(in);
        //Then: The method readInputOtionFromUser() should return -1
        assertEquals(-1, Interacter.readInputOptionFromUser());
        //Teardown
        System.setIn(System.in);
    }

    @Test
    public void testReadNoInputOptionFromUser() {
        //Given: As a user
        //When: I supply no input at all
        ByteArrayInputStream in;
        in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        //Then: The method readInputOtionFromUser() should return -1
        assertEquals(-1, Interacter.readInputOptionFromUser());
        //Teardown
        System.setIn(System.in);
    }

    @Test
    public void testActOnChosenOption() {
        //Given:
        Library library = new Library();
        Interacter interacter = new Interacter(library);
        //When: I supply option 1
        int option = 1;
        //Then: method actOnChosenOption(option) should print a list of all library books
        String expectedListTitle = "\nList of all library books (Title, Author, Year):\n\n";
        String expectedListOfBooks = library.getListOfBooks();

        interacter.actOnChosenOption(option);
        assertEquals( expectedListTitle+expectedListOfBooks+"\n",
                outContent.toString());
    }

    @Test
    public void testActOnChosenOptionInvalid() {
        //Given: As a customer
        Library library = new Library();
        Interacter interacter = new Interacter(library);
        //When: I supply an invalid option
        int option = -5;
        //Then: I want to be notified when I entered an invalid choice.
        String expectedInvalidMessage = "Please select a valid option!";

        interacter.actOnChosenOption(option);
        assertEquals( expectedInvalidMessage+"\n",
                outContent.toString());
    }

}
