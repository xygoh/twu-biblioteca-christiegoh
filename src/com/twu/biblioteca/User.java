package com.twu.biblioteca;

import com.twu.biblioteca.LibraryItems.LibraryItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private String libraryNumber; // xxx-xxxx
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private List<LibraryItem> borrowedItems;
    private boolean isLibrarian = false; // if false is a customer, if true then is a librarian.

    public User(String libraryNumber, String password, String name, String email, String phoneNumber, boolean isLibrarian) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrowedItems = new ArrayList<LibraryItem>();
        this.isLibrarian = isLibrarian;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public void borrowsItem(LibraryItem li) {
        borrowedItems.add(li);
    }

    public void returnsItem(LibraryItem li){
        borrowedItems.remove(li);
    }

    private List<String> getBorrowedItems() {
        List<String> itemNames = new ArrayList<String>();
        for (LibraryItem li : borrowedItems){
            itemNames.add(li.getTitle());

        }
        return itemNames;
    }

    public boolean authenticate(String pw)
    {
        return password.equals(pw);
    }

    public boolean isLibrarian(){
        return isLibrarian;
    }

    public void getInfo(String format){
        System.out.printf(format,libraryNumber,name,email,phoneNumber,getBorrowedItems());
    }
}
