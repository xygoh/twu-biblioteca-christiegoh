package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.LibraryItems.LibraryItem;
import com.twu.biblioteca.User;
import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.LibraryItems.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReturnOption extends MainMenuItem {
    private Biblioteca biblioteca; // make biblioteca setup and protected in abstract class?
    private User user = null;

    public ReturnOption(int index, String name, Biblioteca biblioteca) {
        super(index, name);
        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LibraryItem book;

        try{
            System.out.println("What is the title of the book would you like to return?");
            String title = br.readLine().trim().toLowerCase();
            book = biblioteca.searchLibrary(title);
            if(book == null) {
                System.out.println("Unsuccessful Return. That is not a valid book. It does not exist in our system.");
            }else{
                System.out.println("Thank you for returning the book");
                book.checkIn();
            }
        }catch (IOException e){
            System.out.println("IO Exception caught: Return Option");
        }
    }
}

