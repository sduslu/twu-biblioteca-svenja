package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Medium> inventory;

    public Library() {
        ArrayList<Medium> listOfMediums = new ArrayList<Medium>();
        listOfMediums.add(new Book("Alice in Wonderland", "Lewis Carrol" ,1865));
        listOfMediums.add(new Book("Oliver Twist", "Charles Dickens" ,1839));
        listOfMediums.add(new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954));

        listOfMediums.add(new Movie("101 Dalmatians", "Stephen Herek", 3, 1996));
        listOfMediums.add(new Movie("The Jungle Book", "Wolfgang Reithermann", 9, 1967));
        listOfMediums.add(new Movie("Star Wars", "George Lucas", 8, 1977));
        this.inventory = listOfMediums;
    }

    public Library(ArrayList<Medium> listOfMediums ) {
        this.inventory = listOfMediums;
    }

    public String getListOfBooks() {

        String listOfBooks = "";
        for( Medium medium : this.getInventory() ) {
            if( medium instanceof Book && medium.isAvailable()) {
                listOfBooks += medium.toString();
                listOfBooks += "\n";
            }
        }
        return listOfBooks;
    }

    public String getListOfMovies() {
        String listOfMovies = "";
        for( Medium medium : this.getInventory() ) {
            if( medium instanceof Movie && medium.isAvailable()) {
                listOfMovies += medium.toString();
                listOfMovies += "\n";
            }
        }
        return listOfMovies;
    }

    public ArrayList<Medium> getInventory() {
        return this.inventory;
    }

    public boolean containsAvailable(String title) {
        for( Medium medium : this.getInventory() ) {
            if( medium.getTitle().equals(title) && medium.isAvailable() ) {
                return true;
            }
        }
        return false;
    }

    public boolean containsCheckedoutMedium(String title) {
        for( Medium medium : this.getInventory() ) {
            if( medium.getTitle().equals(title) && !medium.isAvailable() ) {
                return true;
            }
        }
        return false;
    }

    public void checkout(String title) {
        assert(this.containsAvailable(title));
        for( Medium medium : this.getInventory()) {
            if( title.equals(medium.getTitle()) ) {
                medium.setAvailable(false);
                return;
            }
        }
    }

    public void returnMedium(String title) {
        assert(this.containsCheckedoutMedium(title));
        for( Medium medium : this.getInventory()) {
            if( title.equals(medium.getTitle()) && !medium.isAvailable()) {
                medium.setAvailable(true);
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
