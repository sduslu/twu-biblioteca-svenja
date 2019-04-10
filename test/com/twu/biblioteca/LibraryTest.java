package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.ListResourceBundle;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void testDefaultConstructor() {
        //Given
        //When
        Library library = new Library();
        //Then
        assertEquals(3, library.getInventory().size());
        assertEquals("Charles Dickens", library.getInventory().get(1).getAuthor());
    }

    @Test
    public void testConstructor() {
        //Given
        Book book1 = new Book("title1", "author1", 1234);
        Book book2 = new Book("title2", "author2", 5678);
        ArrayList<Book> shortListOfBooks = new ArrayList<Book> ();
        shortListOfBooks.add(book1);
        shortListOfBooks.add(book2);
        //When
        Library library = new Library(shortListOfBooks);
        //Then
        assertEquals( 2, library.getInventory().size());
        assertEquals(1234, library.getInventory().get(0).getYear());
    }

    @Test
    public void testGetListOfBooks() {
        //Given
        Book book1 = new Book("title1", "author1", 1234);
        Book book2 = new Book("title2", "author2", 5678);
        ArrayList<Book> shortListOfBooks = new ArrayList<Book> ();
        shortListOfBooks.add(book1);
        shortListOfBooks.add(book2);
        //When
        Library library = new Library(shortListOfBooks);
        //Then
        String expectedListOfBooks = "title1,author1,1234\ntitle2,author2,5678\n";
        assertEquals( expectedListOfBooks, library.getListOfBooks());
    }
}
