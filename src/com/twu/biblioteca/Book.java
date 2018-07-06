package com.twu.biblioteca;

public class Book {
    private String title;
    private int year;
    private Author author;
    private boolean available;

    private User user=null;

    public Book(String title, int year, Author author, boolean available) {
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

    public void getDetails(String format){
        System.out.printf(format,title,author,year);
    }

    public boolean isAvailable(){
        return available;
    }

    public User getUser() {
        return user;
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
