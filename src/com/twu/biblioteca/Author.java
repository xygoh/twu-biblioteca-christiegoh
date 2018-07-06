package com.twu.biblioteca;

import java.util.List;

public class Author {
    String firstName;
    String lastName;
    List<Book> books;

    public Author(String firstName, String lastName, List<Book> books){
        this.firstName=firstName;
        this.lastName=lastName;
        this.books=books;
    }

    public void addBook(Book b){
        books.add(b);
    }

    public void addBooks(List<Book> newBooks){
        books.addAll(newBooks);
    }

    public List<Book> getBooks(){
        return books;
    }
}
