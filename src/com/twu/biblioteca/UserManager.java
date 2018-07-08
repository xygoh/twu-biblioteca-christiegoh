package com.twu.biblioteca;

import java.util.Hashtable;
import java.util.Set;

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

    public void setCurrentUser(User currUser){
        currentUser = currUser;
    }

    // library number, name, email, phone number, borrowed Items
    public void displayUserAccounts(){
        String format = "%-20s%-25s%-30s%-25s%-25s%n";
        System.out.printf(format,"Library No.","Name","E-mail","Phone No.","Borrowed Items?");
        if (currentUser.isLibrarian()){
            // print all user accounts
            Set<String> keys = passwordFile.keySet();
            for (String key : keys) {
                User u = passwordFile.get(key);
                u.getInfo(format);
            }
            System.out.println("User Accounts");
        }else {
            currentUser.getInfo(format);
        }
    }
}
