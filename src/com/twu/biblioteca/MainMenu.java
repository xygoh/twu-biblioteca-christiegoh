package com.twu.biblioteca;

import com.twu.biblioteca.MainMenuItems.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;

public class MainMenu {
    ArrayList<MainMenuItem> menuOptions;
    Biblioteca biblioteca;
    int itemCounter=1;

    public MainMenu(Biblioteca biblioteca) {
        this.menuOptions = new ArrayList<MainMenuItem>();
        this.biblioteca = biblioteca;
        MainMenuItem m = new ListBooksOption(itemCounter,"List Books",biblioteca);
        MainMenuItem m1 = new QuitOption(itemCounter+=1,"Quit");
        MainMenuItem m2 = new CheckOutOption(itemCounter+=1,"Checkout a Book",biblioteca);
        MainMenuItem m3 = new ReturnOption(itemCounter+=1,"Return a Book",biblioteca);
        menuOptions.add(m);
        menuOptions.add(m1);
        menuOptions.add(m2);
        menuOptions.add(m3);
        itemCounter++;
    }

    private void listOptions(){
        System.out.println("");
        System.out.println("MAIN MENU");
        System.out.println("--------------------");
        for (MainMenuItem o : menuOptions){
            String s = " "+ (o.getIndex()+1) + ". " + o.getName();
            System.out.println(s);
        }
        System.out.println("--------------------");
    }

    public void run(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            boolean quit = false;
            while (!quit){
                listOptions();
                System.out.println("Enter Option Number: ");
                    //int option = 1;
                    int option = Integer.parseInt(br.readLine())-1;
                    selectOption(option);
                    quit = true;
            }
        }catch (Exception e){}
    }

    private void selectOption(int option){
        if (!isValid(option)){
            System.out.println("Invalid Option");
            throw new IllegalArgumentException("Invalid Option.");
        }
        executeOption(option);
    }

    private boolean isValid(int option){
        if (option < 0 || option > menuOptions.size()-1){
            return false;
        }
        return true;
    }

    private void executeOption(int option){
        menuOptions.get(option).run();
    }

}
