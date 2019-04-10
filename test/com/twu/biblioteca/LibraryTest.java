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

    @Test
    public void testLibraryContainsAvailableBook() {
        //Given: As a user
        Library library = new Library();
        String bookTitle = "Alice in Wonderland";
        //When: A book is in the library
        boolean libraryContainsBook = library.containsAvailable(bookTitle);
        //Then: I want to know that it is there
        assertEquals( true, libraryContainsBook);
    }

    @Test
    public void testLibraryDoesNotContainBook() {
        //Given: As a user
        Library library = new Library();
        String bookTitle = "Gulivers Adventures";
        //When: A book is in the library
        boolean libraryContainsBook = library.containsAvailable(bookTitle);
        //Then: I want to know that it is there
        assertEquals( false, libraryContainsBook);
    }

    @Test
    public void testCheckout() {
        //Given: As a user
        Library library = new Library();
        String bookTitle = "Alice in Wonderland";
        assert(library.containsAvailable(bookTitle));
        //When: An existing book
        library.checkout(bookTitle);
        //Then: I want to checkout that book
        assertEquals( false, library.containsAvailable(bookTitle));
    }
}
