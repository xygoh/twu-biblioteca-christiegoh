package com.twu.biblioteca.Persons;

import com.twu.biblioteca.LibraryItems.LibraryItem;

import java.util.List;

public class Director extends Person{

    public Director(String firstName, String lastName, List<LibraryItem> movies) {
        super(firstName,lastName,movies);
    }

    public Director(String firstName, String lastName) {
        super(firstName,lastName);
    }

    public void addMovie(LibraryItem m){
        this.addCreation(m);
    }

    public void addMovies(List<LibraryItem> newMovies){
        this.addCreations(newMovies);
    }

    public List<LibraryItem> getMovies(){
        return this.getCreations();
    }

}
