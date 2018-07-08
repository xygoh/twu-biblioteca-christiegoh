package com.twu.biblioteca.MainMenuItems;

import com.twu.biblioteca.UserManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoginOption extends MainMenuItem {
    private UserManager userManager;

    public LoginOption(String name, UserManager userManager) {
        super(name);
        this.userManager = userManager;
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String libraryNumber = "";
        String password = "";

        try{
            System.out.println("Enter your 7 digit library number xxx-xxxx: ");
            libraryNumber = br.readLine().trim();
            System.out.println("Enter your password: ");
            password = br.readLine();
            userManager.login(libraryNumber,password);
        }catch (Exception e){ }
    }
}
