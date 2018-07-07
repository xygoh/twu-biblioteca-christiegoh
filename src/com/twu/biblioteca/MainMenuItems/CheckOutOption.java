package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.LibraryItems.Book;
import com.twu.biblioteca.LibraryItems.LibraryItem;
import com.twu.biblioteca.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckOutOption extends MainMenuItem {
    private Biblioteca biblioteca;
    private User user = null;  // hardcoded for now

    public CheckOutOption(int index, String name, Biblioteca biblioteca) {
        super(index, name);
        this.biblioteca = biblioteca;
        //this.user = user;
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LibraryItem item=null;

        try{
            System.out.println("What type of item would you like to check out? Type 1 or 2");
            System.out.println("1. Book");
            System.out.println("2. Movie");
            int itemType = Integer.parseInt(br.readLine());
            System.out.println("What is the title you would you like to check out?");
            String title = br.readLine().trim().toLowerCase();

            if (itemType == 1){ // book
                item = biblioteca.searchLibrary(title);
            }else if (itemType == 2){
                item = biblioteca.searchMovies(title);
            }

            if(item == null) {
                System.out.println("Unsuccessful Checkout. Item does not exist in our system.");
            }else if (!item.isAvailable()){
                System.out.println("Unsuccessful Checkout. Item not available.");
            }else if (item.isAvailable()){
                System.out.println("Thank you! Enjoy :)");
                item.checkOut(user);
            }
        }catch (IOException e){
            System.out.println("IO Exception caught: CheckOut Option");
        }
    }
}
