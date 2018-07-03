package com.twu.biblioteca;

public class Book {
    int id;
    String title;
    int year;
    Author author;
    int quantity;

    public Book(int id, String title, int year, Author author, int quantity) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.author = author;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author.firstName + " " + author.lastName;
    }
}
