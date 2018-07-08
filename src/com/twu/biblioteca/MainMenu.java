package com.twu.biblioteca;

import com.sun.tools.javac.Main;
import com.twu.biblioteca.MainMenuItems.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;
import java.util.Arrays;

public class MainMenu {
    ArrayList<MainMenuItem> menuOptions;
    ArrayList<MainMenuItem> menuOptions_LoggedIn;
    ArrayList<MainMenuItem> menuOptions_NoUserLoggedIn;
    UserManager userManager;
    Biblioteca biblioteca;
    int itemCounter=0;

    public MainMenu(Biblioteca biblioteca) {
        this.menuOptions = new ArrayList<MainMenuItem>();
        this.biblioteca = biblioteca;
        MainMenuItem m = new ListBooksOption(itemCounter,"Browse",biblioteca);
        MainMenuItem m1 = new CheckOutOption(itemCounter+=1,"Checkout an Item",biblioteca);
        MainMenuItem m2 = new ReturnOption(itemCounter+=1,"Return an Item",biblioteca);
        MainMenuItem m3 = new QuitOption(itemCounter+=1,"Quit");
        //MainMenuItem m4 = new LoginOption(itemCounter+=1,"Login")
        menuOptions.add(m);
        menuOptions.add(m1);
        menuOptions.add(m2);
        menuOptions.add(m3);
        itemCounter++;
    }

    public MainMenu(Biblioteca biblioteca, UserManager userManager) {
        this.menuOptions = null;
        this.biblioteca = biblioteca;
        this.userManager = userManager;
        MainMenuItem m1 = new LoginOption(itemCounter,"Login",userManager);
        MainMenuItem m2 = new ListBooksOption(itemCounter+=1,"Browse",biblioteca);
        MainMenuItem m3 = new CheckOutOption(itemCounter+=1,"Checkout an Item",biblioteca);
        MainMenuItem m4 = new ReturnOption(itemCounter+=1,"Return an Item",biblioteca);
        MainMenuItem m5 = new UserInformation(itemCounter+=1,"Display User Information",userManager);
        MainMenuItem m6 = new QuitOption(itemCounter+=1,"Quit");

        menuOptions_NoUserLoggedIn = new ArrayList<>();
        menuOptions_LoggedIn = new ArrayList<>();

        menuOptions_NoUserLoggedIn.addAll(Arrays.asList(m1,m2,m6));
        menuOptions_LoggedIn.addAll(Arrays.asList(m2,m3,m4,m5,m6));
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
            while (true){
                if (userManager.isLoggedIn()){
                    menuOptions = menuOptions_LoggedIn;
                }else {
                    menuOptions = menuOptions_NoUserLoggedIn;
                }
                listOptions();
                System.out.println("Enter Option Number: ");
                int option = Integer.parseInt(br.readLine())-1;
                selectOption(option);
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
