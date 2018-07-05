package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Book;
import com.twu.biblioteca.Author;
import com.twu.biblioteca.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckOutOption extends MainMenuItem {
    private Biblioteca biblioteca;
    private User user = null;

    public CheckOutOption(int index, String name, Biblioteca biblioteca) {
        super(index, name);
        this.biblioteca = biblioteca;
        //this.user = user;
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Book book;
        Author author;

        try{
            System.out.println("What is the title of the book would you like to check out?");
            String title = br.readLine().trim().toLowerCase();
            book = biblioteca.searchLibrary(title);
            if(book == null) {
                System.out.println("Unsuccessful Checkout. Book does not exist in our system.");
            }else if (!book.isAvailable()){
                System.out.println("Unsuccessful Checkout. Book not available.");
            }else if (book.isAvailable()){
                System.out.println("Thank you! Enjoy your book :)");
                book.checkOut(user);
            }
        }catch (IOException e){}
    }
}
