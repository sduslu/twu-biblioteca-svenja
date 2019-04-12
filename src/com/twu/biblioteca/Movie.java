package com.twu.biblioteca;

public class Movie extends Medium{
    private String title;
    private String director;
    private int rating;
    private int year;

    public Movie(String title, String director, int rating, int year) {
        this.title = title;
        this.director = director;
        assert(rating >= 0 && rating < 11);
        this.rating = rating;
        this.year = year;
        this.available = true;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return this.rating;
    }

    public int getYear() {
        return this.year;
    }

    public String toString() {
        String s = this.getTitle() + ",";
        s += this.getDirector() + ",";
        s += this.getRating() + ",";
        s += this.getYear();
        return s;
    }
}
