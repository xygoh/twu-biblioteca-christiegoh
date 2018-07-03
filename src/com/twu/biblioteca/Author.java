package com.twu.biblioteca;

import java.util.List;

public class Author {
    int id;
    String firstName;
    String lastName;
    List<Book> books;

    public Author(int id, String firstName, String lastName, List<Book> books){
        this.id=id;
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
