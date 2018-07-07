package com.twu.biblioteca.LibraryItems;

import com.twu.biblioteca.Persons.Person;

public class Book extends LibraryItem{

    public Book(String title, int year, Person author, boolean available) {
        super(title,year,author,available);
    }

    public Person getAuthor() {
        return creator;
    }
}
