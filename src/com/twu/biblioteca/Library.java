package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> inventory;

    public Library() {
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(new Book("Alice in Wonderland", "Lewis Carrol" ,1865));
        listOfBooks.add(new Book("Oliver Twist", "Charles Dickens" ,1839));
        listOfBooks.add(new Book("The Lord of the Rings", "J. R. R. Tolkien", 1954));
        this.inventory = listOfBooks;
    }

    public Library(ArrayList<Book> listOfBooks) {
        this.inventory = listOfBooks;
    }

    public String getListOfBooks() {

        String listOfBooks = "";
        for( int i = 0; i < getInventory().size(); i++) {
            if( this.inventory.get(i).isAvailable()) {
                listOfBooks += this.inventory.get(i).toString();
                listOfBooks += "\n";
            }
        }
        return listOfBooks;
    }

    public ArrayList<Book> getInventory() {
        return this.inventory;
    }

    public boolean containsAvailable(String title) {
        for( int i=0; i<this.getInventory().size(); i++) {
            if( this.getInventory().get(i).getTitle().equals(title) && this.getInventory().get(i).isAvailable() ) {
                return true;
            }
        }
        return false;
    }

    public boolean containsCheckedoutBook(String title) {
        for( int i=0; i<this.getInventory().size(); i++) {
            if( this.getInventory().get(i).getTitle().equals(title) && !this.getInventory().get(i).isAvailable() ) {
                return true;
            }
        }
        return false;
    }

    public void checkout(String title) {
        assert(this.containsAvailable(title));
        for( int i=0; i<this.getInventory().size(); i++) {
            if( title.equals(this.getInventory().get(i).getTitle()) ) {
                this.getInventory().get(i).setAvailable(false);
                return;
            }
        }
    }

    public void returnBook(String title) {
        assert(this.containsCheckedoutBook(title));
        for( int i=0; i<this.getInventory().size(); i++) {
            if( title.equals(this.getInventory().get(i).getTitle()) && !this.getInventory().get(i).isAvailable()) {
                this.getInventory().get(i).setAvailable(true);
                return;
            }
        }
    }
}
