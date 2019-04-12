package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class InteracterTest {

    //Expected Messages:
    private String expectedWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private String expectedOptionMessage = "\nPlease choose one of the following options:" +
            "\n0 : for quitting Biblioteca" +
            "\n1 : for displaying a List of Books" +
            "\n2 : for checking out a book" +
            "\n3 : for returning a book";
    private String expectedCheckoutPrompt = "Please specify which book you want to checkout (Title)";
    private String expectedReturnPrompt = "Please specify which book you want to return (Title)";

    //Streams for testing the command line outputs:
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    UserInputReader userInputReaderMock;

    @Mock
    PrintStream printStreamMock;

    Interacter interacter;
    Library library;

    @Before
    public void setUpStreamsAndInstantiateInteracter() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        library = new Library();
//        printStreamMock = mock(PrintStream.class);
        interacter = new Interacter(library, printStreamMock, userInputReaderMock);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testSimpleWelcomeMessage() {
        //Given

        //When
        interacter.printWelcomeMessages(false);

        //Then
        verify(printStreamMock).println(expectedWelcomeMessage);
    }

    @Test
    public void testWelcomeMessageWithBookList() {
        //Given

        //When
        interacter.printWelcomeMessages(true);

        //Then
        verify(printStreamMock).println(expectedWelcomeMessage);
    }

    @Test
    public void testActOnChosenOption() {
        //Given:
        String expectedListTitle = "\nList of all library books (Title, Author, Year):\n";
        String expectedListOfBooks = library.getListOfMediums(1);

        //When: I supply option 1
        int option = 1;
        interacter.actOnChosenOption(option);

        //Then: method actOnChosenOption(option) should print a list of all library books
        verify(printStreamMock).println(expectedListTitle);
        verify(printStreamMock).println(expectedListOfBooks);
        verify(printStreamMock).println(expectedOptionMessage);
    }

    @Test
    public void testActOnChosenOptionInvalid() {
        //Given: As a customer
        String expectedInvalidMessage = "Please select a valid option!";

        //When: I supply an invalid option
        int option = -5;
        interacter.actOnChosenOption(option);

        //Then: I want to be notified when I entered an invalid choice.
        verify(printStreamMock).println(expectedInvalidMessage);
    }

    @Test
    public void testQuitApplication() {
        //Given: As a customer

        //When: I want to stop using the App
        int option = 0;
        String expectedInvalidMessage = "Exiting Biblioteca. See you soon!";
        interacter.actOnChosenOption(option);

        //Then: I can choose the option to quit
        verify(printStreamMock).println(expectedInvalidMessage);
    }

    @Test
    public void testOptionCheckoutBook() {
        //Given: As a user, when trying to checkout a book
        when(userInputReaderMock.readInputBookFromUser()).thenReturn("");

        //When: I supply option 2
        int option = 2;
        interacter.actOnChosenOption(option);

        //Then: I want to be asked to specify which book to checkout
        String expectedCheckoutMessage = "Sorry, that book is not available";

        verify(printStreamMock).println(expectedCheckoutPrompt);
        verify(printStreamMock).println(expectedCheckoutMessage);
        verify(printStreamMock).println(expectedOptionMessage);
    }

    @Test
    public void testCheckoutSuccessMessage() {
        //Given: As a user, when I want to check out an available book
        when(userInputReaderMock.readInputBookFromUser()).thenReturn("Alice in Wonderland");

        //When: Checking out a book successfully
        interacter.handleBookCheckout();

        //Then: I want to see a success message
        String expectedCheckoutMessage = "Thank you! Enjoy the book";
        verify(printStreamMock).println(expectedCheckoutPrompt);
        verify(printStreamMock).println(expectedCheckoutMessage);
        verify(printStreamMock).println(expectedOptionMessage);
    }

    @Test
    public void testCheckoutFailedMessage() {
        //Given: As a user, when I want to check out a non-available book
        when(userInputReaderMock.readInputBookFromUser()).thenReturn("Peter Pan");

        //When: Checking out a book unsuccessfully
        interacter.handleBookCheckout();

        //Then: I want to see a failing message
        String expectedCheckoutMessage = "Sorry, that book is not available";
//        assertEquals( expectedCheckoutPrompt+expectedCheckoutMessage+expectedOptionMessage, outContent.toString());
        verify(printStreamMock).println(expectedCheckoutPrompt);
        verify(printStreamMock).println(expectedCheckoutMessage);
        verify(printStreamMock).println(expectedOptionMessage);
    }

    @Test
    public void testReturnSuccessMessage() {
        //Given: As a user, when I return a book that belongs to the library
        when(userInputReaderMock.readInputBookFromUser()).thenReturn("Alice in Wonderland");
        library.getInventoryBooks().get(0).setAvailable(false);

        //When: Returning a book successfully
        interacter.handleBookReturn();

        //Then: I want to see a success message
        String expectedReturnMessage = "Thank you for returning the book";
        verify(printStreamMock).println(expectedReturnPrompt);
        verify(printStreamMock).println(expectedReturnMessage);
        verify(printStreamMock).println(expectedOptionMessage);
    }

    @Test
    public void testReturnUnSuccessMessageForeignBook() {
        //Given: As a user
        when(userInputReaderMock.readInputBookFromUser()).thenReturn("Three ???");

        //When: Returning a book that does not belong to this library
        interacter.handleBookReturn();
        //Then: I want to see a failure message
        String expectedReturnMessage = "That is not a valid book to return.";
        verify(printStreamMock).println(expectedReturnPrompt);
        verify(printStreamMock).println(expectedReturnMessage);
        verify(printStreamMock).println(expectedOptionMessage);
    }

    @Test
    public void testReturnUnSuccessMessageAvailableBook() {
        //Given: As a user
        when(userInputReaderMock.readInputBookFromUser()).thenReturn("Alice in Wonderland");

        //When: Returning a book that is not checked out (still available)
        interacter.handleBookReturn();

        //Then: I want to see a failure message
        String expectedReturnMessage = "That is not a valid book to return.";
        verify(printStreamMock).println(expectedReturnPrompt);
        verify(printStreamMock).println(expectedReturnMessage);
        verify(printStreamMock).println(expectedOptionMessage);
    }

}
