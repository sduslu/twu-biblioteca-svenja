package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> inventoryBooks;
    private ArrayList<Movie> inventoryMovies;

    public Library() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("Alice in Wonderland", "Lewis Carrol" ,1865));
        listOfBooks.add(new Book("Oliver Twist", "Charles Dickens" ,1839));
        listOfBooks.add(new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954));
        this.inventoryBooks = listOfBooks;

        ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
        listOfMovies.add(new Movie("101 Dalmatians", "Stephen Herek", 3, 1996));
        listOfMovies.add(new Movie("The Jungle Book", "Wolfgang Reithermann", 9, 1967));
        listOfMovies.add(new Movie("Star Wars", "George Lucas", 8, 1977));
        this.inventoryMovies = listOfMovies;
    }

    public Library(ArrayList<Book> listOfBooks, ArrayList<Movie> listOfMovies ) {
        this.inventoryBooks = listOfBooks;
        this.inventoryMovies = listOfMovies;
    }

    public String getListOfBooks() {

        String listOfBooks = "";
        for( Book book : this.getInventoryBooks() ) {
            if( book.isAvailable()) {
                listOfBooks += book.toString();
                listOfBooks += "\n";
            }
        }
        return listOfBooks;
    }

    public String getListOfMovies() {
        String listOfMovies = "";
        for( Movie movie : this.getInventoryMovies() ) {
            if( movie.isAvailable()) {
                listOfMovies += movie.toString();
                listOfMovies += "\n";
            }
        }
        return listOfMovies;
    }

    private ArrayList<Movie> getInventoryMovies() {
        return this.inventoryMovies;
    }

    public ArrayList<Book> getInventoryBooks() {
        return this.inventoryBooks;
    }

    public boolean containsAvailable(String title) {
        for( Book book : this.getInventoryBooks() ) {
            if( book.getTitle().equals(title) && book.isAvailable() ) {
                return true;
            }
        }
        return false;
    }

    public boolean containsCheckedoutBook(String title) {
        for( Book book : this.getInventoryBooks()) {
            if( book.getTitle().equals(title) && !book.isAvailable() ) {
                return true;
            }
        }
        return false;
    }

    public void checkout(String title) {
        assert(this.containsAvailable(title));
        for( Book book : this.getInventoryBooks()) {
            if( title.equals(book.getTitle()) ) {
                book.setAvailable(false);
                return;
            }
        }
    }

    public void returnBook(String title) {
        assert(this.containsCheckedoutBook(title));
        for( Book book : this.getInventoryBooks()) {
            if( title.equals(book.getTitle()) && !book.isAvailable()) {
                book.setAvailable(true);
                return;
            }
        }
    }

    public String getListOfMediums(int i) {
        assert( i >= 0 && i < 3);
        if( i == 0 ) {
            return getListOfBooks() + getListOfMovies();
        }
        if( i == 1) {
            return getListOfBooks();
        } else if ( i == 2) {
            return getListOfMovies();
        }
        return "";
    }
}
