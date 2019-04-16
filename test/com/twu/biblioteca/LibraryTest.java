package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    @Test
    public void testDefaultConstructor() {
        //Given
        //When
        Library library = new Library();
        //Then
        assertEquals(6, library.getInventory().size());
        assertEquals("Oliver Twist,Charles Dickens,1839", library.getInventory().get(1).toString());
    }

    @Test
    public void testConstructor() {
        //Given
        Book book1 = new Book("title1", "author1", 1234);
        Book book2 = new Book("title2", "author2", 5678);
        ArrayList<Medium> shortListOfBooks = new ArrayList<Medium> ();
        shortListOfBooks.add(book1);
        shortListOfBooks.add(book2);
        //When
        Library library = new Library(shortListOfBooks);
        //Then
        assertEquals( 2, library.getInventory().size());
        assertEquals("title1,author1,1234", library.getInventory().get(0).toString());
    }

    @Test
    public void testGetListOfBooks() {
        //Given
        Book book1 = new Book("title1", "author1", 1234);
        Book book2 = new Book("title2", "author2", 5678);
        ArrayList<Medium> shortListOfBooks = new ArrayList<Medium> ();
        shortListOfBooks.add(book1);
        shortListOfBooks.add(book2);
        //When
        Library library = new Library(shortListOfBooks);
        //Then
        String expectedListOfBooks = "title1,author1,1234\ntitle2,author2,5678\n";
        assertEquals( expectedListOfBooks, library.getListOfMediums(1));
    }

    @Test
    public void testGetListOfMovies() {
        //Given
        Movie movie1 = new Movie("title1", "director1", 5, 1234);
        Movie movie2 = new Movie("title2", "director2", 10, 5678);
        ArrayList<Medium> shortListOfMovies = new ArrayList<Medium> ();
        shortListOfMovies.add(movie1);
        shortListOfMovies.add(movie2);
        //When
        Library library = new Library(shortListOfMovies);
        //Then
        String expectedListOfMovies = "title1,director1,5,1234\ntitle2,director2,10,5678\n";
        assertEquals( expectedListOfMovies, library.getListOfMediums(2));
    }

    @Test
    public void testGetListOfMediums() {
        //Given
        Book book1 = new Book("title1", "author1", 1234);
        Book book2 = new Book("title2", "author2", 5678);
        ArrayList<Medium> shortListOfMediums = new ArrayList<Medium> ();
        shortListOfMediums.add(book1);
        shortListOfMediums.add(book2);
        Movie movie1 = new Movie("title1", "director1", 5, 1234);
        Movie movie2 = new Movie("title2", "director2", 10, 5678);
        shortListOfMediums.add(movie1);
        shortListOfMediums.add(movie2);
        //When
        Library library = new Library(shortListOfMediums);
        //Then
        String expectedListOfBooks = "title1,author1,1234\ntitle2,author2,5678\n";
        String expectedListOfMovies = "title1,director1,5,1234\ntitle2,director2,10,5678\n";
        assertEquals( expectedListOfBooks+expectedListOfMovies, library.getListOfMediums(0));
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
    public void testSuccessfulCheckout() {
        //Given: As a user
        Library library = new Library();
        String bookTitle = "Alice in Wonderland";
        assert(library.containsAvailable(bookTitle));
        //When: I checkout an existing book
        library.checkout(bookTitle);
        //Then: I want this book to be no longer in the available book list
        assertEquals( false, library.containsAvailable(bookTitle));
    }

    @Test
    public void testContainsCheckedoutBook() {
        //Given
        Library library = new Library();
        library.getInventory().get(0).setAvailable(false);
        String bookTitle = "Alice in Wonderland";
        assert( !library.containsAvailable(bookTitle) );
        //When Asked if the book belongs to the library, but is not available
        boolean bookIsCheckedout = library.containsCheckedoutMedium(bookTitle);
        //Then should tell me this.
        assertEquals( true, bookIsCheckedout);
    }

    @Test
    public void testSuccessfulReturn() {
        //Given: As a librarian
        Library library = new Library();
        library.getInventory().get(0).setAvailable(false);
        String bookTitle = "Alice in Wonderland";
        assert( !library.containsAvailable(bookTitle) );
        //When: A user returns a book
        library.returnMedium(bookTitle);
        //Then: I want t that book to appear in the List of available books again.
        assertEquals( true, library.containsAvailable(bookTitle));
    }

    @Test
    public void testLibraryContainsAvailableMovie() {
        //Given: As a user
        Library library = new Library();
        String movieTitle = "Star Wars";
        //When: A medium is in the library
        boolean libraryContainsMedium = library.containsAvailable(movieTitle);
        //Then: I want to know that it is there
        assertEquals( true, libraryContainsMedium);
    }

    @Test
    public void testLibraryDoesNotContainMovie() {
        //Given: As a user
        Library library = new Library();
        String movieTitle = "Star Wars 2";
        //When: A movie is in the library
        boolean libraryContainsMedium = library.containsAvailable(movieTitle);
        //Then: I want to know that it is not there
        assertEquals( false, libraryContainsMedium);
    }

    @Test
    public void testSuccessfulCheckoutMovie() {
        //Given: As a user
        Library library = new Library();
        String movieTitle = "Star Wars";
        assert(library.containsAvailable(movieTitle));
        //When: I checkout an existing book
        library.checkout(movieTitle);
        //Then: I want this book to be no longer in the available book list
        assertEquals( false, library.containsAvailable(movieTitle));
    }
}
