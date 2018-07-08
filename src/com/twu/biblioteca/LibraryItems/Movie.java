package com.twu.biblioteca.LibraryItems;

import com.twu.biblioteca.Persons.Director;
import com.twu.biblioteca.Persons.Person;
import com.twu.biblioteca.Rating;

public class Movie extends LibraryItem{
    private Rating rating;

    public Movie(String title, int year, Director director, boolean available, Rating rating) {
        super(title,year,director,available);
        this.rating = rating;
    }

    public Person getDirector() {
        return creator;
    }

    @Override
    public void getDetails(String format){
        System.out.printf(format,title,this.getDirector().getFullName(),year,rating.getRating());
    }
}
