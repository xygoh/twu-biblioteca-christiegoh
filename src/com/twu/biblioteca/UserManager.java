package com.twu.biblioteca;

import com.twu.biblioteca.LibraryItems.LibraryItem;

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
        }else {
            if (!u.authenticate(password)) {
                System.out.println("Password doesn't match");
            }else {
                System.out.println("Login Successful!");
                currentUser = u;
            }
        }
    }

    public void addUser(User u) {
        passwordFile.put(u.getLibraryNumber(),u);
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public void setCurrentUser(User currUser){
        currentUser = currUser;
    }

    public boolean isLoggedIn(){
        return currentUser != null;
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

        }else { // print own's info
            currentUser.getInfo(format);
        }
    }

    public void defaultSetupUsers(){
        User u_librarian = new User("000-0000","password","Mr. Librarian","librarian@bangalorelib.com","0123456789",true);
        User u_cust1 = new User("001-0000","ilovedogs","Beatrice Baudelaire", "beatrice@gmail.com","0123456788",false);
        User u_cust2 = new User("001-0001","123456","Al Funcoot", "notOlaf@gmail.com","0123456777",false);

        this.addUser(u_librarian);
        this.addUser(u_cust1);
        this.addUser(u_cust2);
    }

    public void checkIn(LibraryItem li) {
        li.checkIn();
        currentUser.returnsItem(li);
    }

    public void checkOut(LibraryItem li) {
        li.checkOut(currentUser);
        currentUser.borrowsItem(li);
    }
}
