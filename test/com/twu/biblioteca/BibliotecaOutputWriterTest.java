package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaOutputWriterTest {

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
        //Given

        //When
        BibliotecaOutputWriter.printWelcomeMessages(false);

        //Then
        String expectedWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        assertEquals( expectedWelcomeMessage,
                outContent.toString());
    }

    @Test
    public void testWelcomeMessageWithBookList() {
        //Given

        //When
        BibliotecaOutputWriter.printWelcomeMessages(true);

        //Then
        String expectedWelcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n\n";
        String expectedOptionMessage = "Please choose one of the following options:\n1 : for displaying a List of Books\n";
        assertEquals( expectedWelcomeMessage+expectedOptionMessage,
                outContent.toString());
    }
}
