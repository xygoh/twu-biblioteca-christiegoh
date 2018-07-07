package com.twu.biblioteca.Persons;

import com.twu.biblioteca.LibraryItems.LibraryItem;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String firstName;
    String lastName;
    List<LibraryItem> creations;

    public Person(String firstName, String lastName, List<LibraryItem> creations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.creations = creations;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.creations = new ArrayList<LibraryItem>();
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    protected void addCreation(LibraryItem li){
        creations.add(li);
    }

    protected  void addCreations(List<? extends LibraryItem> litems){
        creations.addAll(litems);
    }

    protected List<LibraryItem> getCreations(){
        return creations;
    }

}
