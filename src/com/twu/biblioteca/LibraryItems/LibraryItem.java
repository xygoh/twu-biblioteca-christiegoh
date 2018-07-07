package com.twu.biblioteca.LibraryItems;

import com.twu.biblioteca.Persons.Person;
import com.twu.biblioteca.User;

abstract public class LibraryItem {
    protected String title;
    protected int year;
    protected boolean available;
    protected User user = null;
    protected Person creator;

    public LibraryItem(String title, int year, Person creator, boolean available) {
        this.title = title;
        this.year = year;
        this.creator = creator;
        this.available = available;
    }

    public String getTitle(){
        return title;
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

    public void getDetails(String format){
        System.out.printf(format,title,creator.getFullName(),year);
    }
}
