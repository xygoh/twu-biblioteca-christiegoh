package com.twu.biblioteca.Persons;

import com.twu.biblioteca.LibraryItems.Book;
import com.twu.biblioteca.LibraryItems.LibraryItem;

import java.util.List;

public class Author extends Person {

    public Author(String firstName, String lastName, List<LibraryItem> books){
        super(firstName,lastName,books);
    }

    public Author(String firstName, String lastName){
        super(firstName,lastName);
    }

    public void addBook(Book b){
        this.addCreation(b);
    }

    public void addBooks(List<Book> newBooks){
       this.addCreations(newBooks);
    }

    public List<LibraryItem> getBooks(){
         return this.getCreations();
    }
}
