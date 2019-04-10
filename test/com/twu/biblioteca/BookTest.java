package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testCreateBook() {
        //Given
        String title = "bookTitle";
        String author = "author";
        int year = 2019;
        //When
        Book book = new Book(title, author, year);
        //Then
        assertEquals(title, book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(year, book.getYear());
    }

    @Test
    public void testToString() {
        //Given
        String title = "bookTitle";
        String author = "author";
        int year = 2019;
        //When
        Book book = new Book(title, author, year);
        //Then
        assertEquals("bookTitle,author,2019", book.toString());
    }
}
