package com.twu.biblioteca;

import com.twu.biblioteca.MainMenuItems.LoginOption;
import com.twu.biblioteca.MainMenuItems.MainMenuItem;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.Hashtable;

import static org.junit.Assert.*;

// general tests go here first will get refactored into more appropriate test classes later on.
public class UserStoriesTests {
    @Rule
    public final SystemOutRule sor = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream si = TextFromStandardInputStream.emptyStandardInputStream();

/* User Accounts - Login - As a librarian, I want to know who has checked out a book,
 so that I can hold them accountable for returning it. Users must now login using their library number
 (which is in the format xxx-xxxx) and a password in order to check-out and return books.
 User credentials are predefined, so registering new users is not part of this story.*/
    @Test
    public void userAccounts_Librarian(){ // list of userAccounts and books borrowed
        UserManager uMan = new UserManager();
        User u_librarian = new User("000-0000","password","Mr. Librarian","librarian@bangalorelib.com","0123456789",true);
        User u_cust1 = new User("001-0000","ilovedogs","Beatrice Baudelaire", "beatrice@gmail.com","0123456788",false);
        uMan.addUser(u_librarian);
        uMan.addUser(u_cust1);
        uMan.setCurrentUser(u_librarian);
        uMan.displayUserAccounts();
        assertTrue(sor.getLog().contains("User Accounts"));
    }

// User Accounts - User information - As a customer,
// I want to be able to see my
// user information (name, email address and phone number),
// so that I know that the library can contact me.
// This option should only be available when the customer is logged in and
// should only display that customer’s information.
    @Test
    public void userAccounts_Customer() {
        UserManager uMan = new UserManager();
        User u_librarian = new User("000-0000","password","Mr. Librarian","librarian@bangalorelib.com","0123456789",true);
        User u_cust1 = new User("001-0000","ilovedogs","Beatrice Baudelaire", "beatrice@gmail.com","0123456788",false);
        uMan.addUser(u_librarian);
        uMan.addUser(u_cust1);
        uMan.setCurrentUser(u_cust1);
        uMan.displayUserAccounts();
        assertTrue(sor.getLog().contains("Beatrice Baudelaire"));
        assertFalse(sor.getLog().contains("Mr. Librarian"));
    }
}