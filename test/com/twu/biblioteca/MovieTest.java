package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void testCreateMovie() {
        //Given
        String title = "movieTitle";
        String director = "director";
        int rating = 3;
        int year = 2019;
        //When
        Movie movie = new Movie(title, director, rating, year);

        //Then
        assertEquals(title, movie.getTitle());
        assertEquals(director, movie.getDirector());
        assertEquals(rating, movie.getRating());
        assertEquals(year, movie.getYear());
    }

    @Test
    public void testToString() {
        //Given
        String title = "movieTitle";
        String director = "director";
        int rating = 3;
        int year = 2019;
        //When
        Movie movie = new Movie(title, director, rating, year);
        //Then
        assertEquals("movieTitle,director,3,2019", movie.toString());
    }
}
