package com.twu.biblioteca;

public class Book {
    private int id;
    private String title;
    private int year;
    private Author author;
    private int quantity;

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

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getQuantity() {
        return quantity;
    }
}
