package com.twu.biblioteca;

public class Book {
    private int id;
    private String title;
    private int year;
    private Author author;
    private boolean available;
    private User user=null;

    public Book(int id, String title, int year, Author author, boolean available) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.author = author;
        this.available = available;
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

    public boolean isAvailable(){
        return available;
    }

    public void checkOut(User u){
        available = false;
        user = u;
    }

    public void checkIn(){
        available = true;
        user = null;
    }
}
