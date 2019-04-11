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
        for( Book book : this.getInventory() ) {
            if( book.isAvailable()) {
                listOfBooks += book.toString();
                listOfBooks += "\n";
            }
        }
        return listOfBooks;
    }

    public ArrayList<Book> getInventory() {
        return this.inventory;
    }

    public boolean containsAvailable(String title) {
        for( Book book : this.getInventory() ) {
            if( book.getTitle().equals(title) && book.isAvailable() ) {
                return true;
            }
        }
        return false;
    }

    public boolean containsCheckedoutBook(String title) {
        for( Book book : this.getInventory()) {
            if( book.getTitle().equals(title) && !book.isAvailable() ) {
                return true;
            }
        }
        return false;
    }

    public void checkout(String title) {
        assert(this.containsAvailable(title));
        for( Book book : this.getInventory()) {
            if( title.equals(book.getTitle()) ) {
                book.setAvailable(false);
                return;
            }
        }
    }

    public void returnBook(String title) {
        assert(this.containsCheckedoutBook(title));
        for( Book book : this.getInventory()) {
            if( title.equals(book.getTitle()) && !book.isAvailable()) {
                book.setAvailable(true);
                return;
            }
        }
    }
}
