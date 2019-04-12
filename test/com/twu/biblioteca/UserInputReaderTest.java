package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class UserInputReaderTest {

    @Test
    public void testReadInputOptionFromUser() {
        //Given
        UserInputReader userInputReader = new UserInputReader();
        //When
        ByteArrayInputStream in;
        in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        //Then
        assertEquals(1, userInputReader.readInputOptionFromUser());
        //Teardown
        System.setIn(System.in);
    }

    @Test
    public void testReadInvalidInputOptionFromUser() {
        //Given: As a user
        UserInputReader userInputReader = new UserInputReader();
        //When: I supply invalid input
        ByteArrayInputStream in;
        in = new ByteArrayInputStream("A".getBytes());
        System.setIn(in);
        //Then: The method readInputOtionFromUser() should return -1
        assertEquals(-1, userInputReader.readInputOptionFromUser());
        //Teardown
        System.setIn(System.in);
    }

    @Test
    public void testReadNoInputOptionFromUser() {
        //Given: As a user
        UserInputReader userInputReader = new UserInputReader();
        //When: I supply no input at all
        ByteArrayInputStream in;
        in = new ByteArrayInputStream("".getBytes());
        System.setIn(in);
        //Then: The method readInputOtionFromUser() should return -1
        assertEquals(-1, userInputReader.readInputOptionFromUser());
        //Teardown
        System.setIn(System.in);
    }
}
