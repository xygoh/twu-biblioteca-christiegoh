package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.Biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListBooksOption extends MainMenuItem {
    private Biblioteca biblioteca;

    public ListBooksOption(String name,Biblioteca biblioteca){
        super(name);
        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("What type of item? Type 1 or 2");
            System.out.println("1. Book");
            System.out.println("2. Movie");
            int itemType = Integer.parseInt(br.readLine());
            if (itemType == 1){ // book
                biblioteca.listBooks();
            }else if (itemType == 2){
                biblioteca.listMovies();
            }
        }catch (IOException e){}

    }
}
