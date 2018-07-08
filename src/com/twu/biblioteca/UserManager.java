package com.twu.biblioteca;

import java.util.Hashtable;

public class UserManager {
    private Hashtable<String,User> passwordFile;
    private User currentUser = null;

    public UserManager(Hashtable<String, User> passwordFile) {
        this.passwordFile = passwordFile;
    }

    public UserManager() {
        this.passwordFile = new Hashtable<String,User>();
    }

    public void login(String libraryNumber, String password) {
        User u = passwordFile.get(libraryNumber);
        if (u == null){
           System.out.println("User doesn't exist in our system");
        }

        if (!u.authenticate(password)) {
            System.out.println("Password doesn't match");
        }else {
            System.out.println("Login Successful!");
            currentUser = u;
        }
    }

    public void addUser(User u) {
        passwordFile.put(u.getLibraryNumber(),u);
    }
}
