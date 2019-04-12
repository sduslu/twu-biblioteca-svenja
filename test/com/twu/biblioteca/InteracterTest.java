package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class InteracterTest {

    //Expected Messages:
    private String expectedWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
    private String expectedOptionMessage = "Please choose one of the following options:" +
            "\n0 : for quitting Biblioteca" +
            "\n1 : for displaying a List of Books" +
            "\n2 : for checking out a book" +
            "\n3 : for returning a book\n";
    private String expectedCheckoutPrompt = "Please specify which book you want to checkout (Title)\n";
    private String expectedReturnPrompt = "Please specify which book you want to return (Title)\n";


    //Streams for testing the command line outputs:
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    UserInputReader userInputReaderMock;

    Interacter interacter;
    PrintStream printStream;
    Library library;



    @Before
    public void setUpStreamsAndInstantiateInteracter() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        library = new Library();
        printStream = System.out;
        interacter = new Interacter(library, printStream, userInputReaderMock);
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
        interacter.printWelcomeMessages(false);

        //Then: I want to see a welcome message
        assertEquals( expectedWelcomeMessage,
                outContent.toString());
    }

    @Test
    public void testWelcomeMessageWithBookList() {
        //Given: As a user

        //When: After the welcome message appears
        interacter.printWelcomeMessages(true);

        //Then: I want to see a menu of options before the list of all library books

        assertEquals( expectedWelcomeMessage+"\n"+expectedOptionMessage,
                outContent.toString());
    }

    @Test
    public void testActOnChosenOption() {
        //Given:

        //When: I supply option 1
        int option = 1;
        //Then: method actOnChosenOption(option) should print a list of all library books
        String expectedListTitle = "\nList of all library books (Title, Author, Year):\n\n";
        String expectedListOfBooks = library.getListOfBooks();

        interacter.actOnChosenOption(option);
        assertEquals( expectedListTitle+expectedListOfBooks+"\n"+"\n"+expectedOptionMessage,
                outContent.toString());
    }

    @Test
    public void testActOnChosenOptionInvalid() {
        //Given: As a customer

        //When: I supply an invalid option
        int option = -5;
        //Then: I want to be notified when I entered an invalid choice.
        String expectedInvalidMessage = "Please select a valid option!";

        interacter.actOnChosenOption(option);
        assertEquals( expectedInvalidMessage+"\n",
                outContent.toString());
    }

    @Test
    public void testQuitApplication() {
        //Given: As a customer

        //When: I want to stop using the App
        int option = 0;
        //Then: I can choose the option to quit
        String expectedInvalidMessage = "Exiting Biblioteca. See you soon!";

        interacter.actOnChosenOption(option);
        assertEquals( expectedInvalidMessage+"\n",
                outContent.toString());
    }

    @Test
    public void testOptionCheckoutBook() {
        //Given: As a user, when trying to checkout a book
        when(userInputReaderMock.readInputBookFromUser()).thenReturn("");

        //When: I supply option 2
        int option = 2;
        interacter.actOnChosenOption(option);

        //Then: I want to be asked to specify which book to checkout
        String expectedCheckoutMessage = "Sorry, that book is not available\n\n";

        assertEquals( expectedCheckoutPrompt+expectedCheckoutMessage+expectedOptionMessage,
                outContent.toString());
    }

    @Test
    public void testCheckoutSuccessMessage() {
        //Given: As a user, when I want to check out an available book
        when(userInputReaderMock.readInputBookFromUser()).thenReturn("Alice in Wonderland");

        //When: Checking out a book successfully
        interacter.handleBookCheckout();

        //Then: I want to see a success message
        String expectedCheckoutMessage = "Thank you! Enjoy the book\n\n";
        assertEquals( expectedCheckoutPrompt+expectedCheckoutMessage+expectedOptionMessage, outContent.toString());
    }

    @Test
    public void testCheckoutFailedMessage() {
        //Given: As a user, when I want to check out a non-available book
        when(userInputReaderMock.readInputBookFromUser()).thenReturn("Peter Pan");

        //When: Checking out a book unsuccessfully
        interacter.handleBookCheckout();

        //Then: I want to see a failing message
        String expectedCheckoutMessage = "Sorry, that book is not available\n\n";
        assertEquals( expectedCheckoutPrompt+expectedCheckoutMessage+expectedOptionMessage, outContent.toString());
    }

    @Test
    public void testReturnSuccessMessage() {
        //Given: As a user, when I return a book that belongs to the library
        when(userInputReaderMock.readInputBookFromUser()).thenReturn("Alice in Wonderland");
        library.getInventory().get(0).setAvailable(false);

        //When: Returning a book successfully
        interacter.handleBookReturn();

        //Then: I want to see a success message
        String expectedReturnMessage = "Thank you for returning the book\n\n";
        assertEquals( expectedReturnPrompt+expectedReturnMessage+expectedOptionMessage, outContent.toString());
    }

    @Test
    public void testReturnUnSuccessMessageForeignBook() {
        //Given: As a user
        when(userInputReaderMock.readInputBookFromUser()).thenReturn("Three ???");

        //When: Returning a book that does not belong to this library
        interacter.handleBookReturn();
        //Then: I want to see a failure message
        String expectedReturnMessage = "That is not a valid book to return.\n\n";
        assertEquals( expectedReturnPrompt+expectedReturnMessage+expectedOptionMessage, outContent.toString());
    }

    @Test
    public void testReturnUnSuccessMessageAvailableBook() {
        //Given: As a user
        when(userInputReaderMock.readInputBookFromUser()).thenReturn("Alice in Wonderland");

        //When: Returning a book that is not checked out (still available)
        interacter.handleBookReturn();

        //Then: I want to see a failure message
        String expectedReturnMessage = "That is not a valid book to return.\n\n";
        assertEquals( expectedReturnPrompt+expectedReturnMessage+expectedOptionMessage, outContent.toString());
    }

}
