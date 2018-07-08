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
            // user doesn't exist
        }

        if (!u.authenticate(password)) {
            // password does not match
        }else {
            System.out.println("Login Successful!");
            currentUser = u;
        }
    }

    public void addUser(User u) {
        passwordFile.put(u.getLibraryNumber(),u);
    }
}
