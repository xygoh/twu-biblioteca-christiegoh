package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.LibraryItems.LibraryItem;
import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.UserManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReturnOption extends MainMenuItem {
    private Biblioteca biblioteca;
    private UserManager userMan;

    public ReturnOption(String name, Biblioteca biblioteca, UserManager userMan) {
        super(name);
        this.biblioteca = biblioteca;
        this.userMan = userMan;
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LibraryItem item=null;

        try{
            System.out.println("What type of item would you like to return? Type 1 or 2");
            System.out.println("1. Book");
            System.out.println("2. Movie");
            int itemType = Integer.parseInt(br.readLine());
            System.out.println("What is the title you would you like to return?");
            String title = br.readLine().trim().toLowerCase();
            if (itemType == 1){ // book
                item = biblioteca.searchLibrary(title);
            }else if (itemType == 2){ // movie
                item = biblioteca.searchMovies(title);
            }
            if(item == null) {
                System.out.println("Unsuccessful Return. That is not a valid item. It does not exist in our system.");
            }else{
                System.out.println("Thank you for returning it");
                userMan.checkIn(item);
            }
        }catch (IOException e){
            System.out.println("IO Exception caught: Return Option");
        }
    }
}

